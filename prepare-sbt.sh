#!/bin/sh
mkdir -p src/{main,test}/{java,resources,scala}
mkdir lib project target

# create an initial build.sbt file
echo 'name := "MyProject"

version := "1.0"

scalaVersion := "2.10.0"' > build.sbt

# Um sbt-Projekte in eclipse oeffnen zu koennen
echo 'addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "4.0.0")' > project/plugins.sbt

# Anschliessend im Verzeichnis 'sbt' aufrufen und eclipse
# sbt
# > eclipse
