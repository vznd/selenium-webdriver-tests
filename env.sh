#!/bin/bash

echo "Install gnupg2, wget, xvfb and unzip"
apt-get update
apt-get install -y gnupg2
apt-get install -y wget xvfb unzip

echo "Install Chrome Browser"
wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -
echo "deb http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list
apt-get update -y
apt-get install -y google-chrome-stable

echo "Setup chromedriver"
mkdir -p $CHROMEDRIVER_DIR
wget -q --continue -P $CHROMEDRIVER_DIR "http://chromedriver.storage.googleapis.com/$CHROMEDRIVER_VERSION/chromedriver_linux64.zip"
unzip $CHROMEDRIVER_DIR/chromedriver* -d $CHROMEDRIVER_DIR
export PATH=$CHROMEDRIVER_DIR:$PATH