#!/bin/bash

export CATALINA_HOME=/Users/macbookpro/IdeaProjects/tasks

runcrud.sh() {
sh ./runcrud.sh
}

open_browser() {
$ open -a /Applications/Safari.app http://localhost:8080/crud/v1/task/getTasks
}

fail() {
  echo "There were errors"
}

if runcrud.sh; then
open_browser

else
   fail
fi