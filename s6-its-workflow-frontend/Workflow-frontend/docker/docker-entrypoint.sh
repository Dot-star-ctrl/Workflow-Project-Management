#!/bin/sh
set -e

if [ "$NODE_ENV" = 'development' ]; then
  npm cache clean --force
  npm install
fi

exec "$@"
