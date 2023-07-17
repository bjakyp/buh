#!/bin/bash
set -e

cp build/libs/buh-project-0.0.1-SNAPSHOT.jar $OLDPWD/jars/buh-project.jar
sudo systemctl restart buh
