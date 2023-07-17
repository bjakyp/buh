FROM ubuntu:22.04 as build
WORKDIR /work
ENV LANG en_US.UTF-8
ENV PG_ROOT /opt/pg

RUN apt-get update
RUN #apt-get upgrade
RUN apt-get install -y build-essential libreadline-dev zlib1g-dev flex bison libxml2-dev libxslt-dev libssl-dev libxml2-utils xsltproc
RUN apt-get install -y wget
RUN apt-get install -y locales

RUN localedef -i en_US -c -f UTF-8 en_US.UTF-8

RUN wget "https://ftp.postgresql.org/pub/source/v14.7/postgresql-14.7.tar.bz2" \
    "https://ftp.postgresql.org/pub/source/v14.7/postgresql-14.7.tar.bz2.md5" \
    "https://ftp.postgresql.org/pub/source/v14.7/postgresql-14.7.tar.bz2.sha256"

RUN md5sum -c postgresql-14.7.tar.bz2.md5
RUN sha256sum -c postgresql-14.7.tar.bz2.sha256

RUN set -ex; \
    tar xf postgresql-14.7.tar.bz2; \
    cd postgresql-14.7; \
    echo "#define NAMEDATALEN 128" >> src/include/pg_config_manual.h; \
    ./configure --prefix=$PG_ROOT; \
    make -j `nproc` all; \
    make install;

FROM ubuntu:22.04
WORKDIR /db
ENV LANG en_US.UTF-8
ENV PG_ROOT /opt/pg
ENV PG_DATA /opt/pg-data
ENV PATH $PATH:/opt/pg/bin
ENV PG_USER postgres
ENV PG_PASS postgres
ENV PG_DB buhproject

COPY --from=build $PG_ROOT $PG_ROOT

RUN apt-get update
RUN apt-get install -y locales
RUN localedef -i en_US -c -f UTF-8 en_US.UTF-8

RUN apt-get install -y libreadline8

RUN set -ex; \
    home="/home/postgres"; \
    groupadd -r postgres --gid=999; \
    useradd -r -g postgres --uid=999 --home-dir=$home --shell=/bin/bash postgres; \
    mkdir -p $home; \
    chown -R postgres:postgres $home;

RUN mkdir $PG_DATA && chown -R postgres:postgres $PG_DATA && chmod 777 $PG_DATA
VOLUME $PG_DATA

USER postgres:postgres
RUN set -ex; \
    initdb -D $PG_DATA; \
    echo "listen_addresses = '*'" >> $PG_DATA/postgresql.conf; \
    echo "host all all 0.0.0.0/0 md5" >> $PG_DATA/pg_hba.conf; \
    pg_ctl -D $PG_DATA -w start; \
    psql -c "alter user $PG_USER with password '$PG_PASS'"; \
#    psql -c "create user $PG_USER with login password '$PG_PASS'" postgres; \
    psql -c "create database $PG_DB with owner = $PG_USER"; \
    pg_ctl -D $PG_DATA stop -m fast;

EXPOSE 5432
CMD postmaster -D $PG_DATA
