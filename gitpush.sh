#!/bin/sh

echo -e "Enter commit message"
read message

git add --all
git commit -a -m '$message'
git push origin master