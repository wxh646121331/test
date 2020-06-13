#!/usr/bin/env bash
. zkEnv.sh

export CLASSPATH="build/classes/java/main:$CLASSPATH"
mkdir -p data
java com.wxh.zookeeper.watchclient.Executor "$@"