#!/bin/bash

export CATALINA_HOME=/Users/macbookpro/IdeaProjects/tasks

if ./runcrud.sh; then
open_browser() {
$ open -a /Applications/Safari.app http://localhost:8080/crud/v1/task/getTasks
}

else
   fail() {
  echo "There were errors"
}
fi