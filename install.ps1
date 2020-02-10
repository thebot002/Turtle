Set-Location ($PSScriptRoot + "\src")
$DesktopPath = [Environment]::GetFolderPath("Desktop")

$Exercise_folder = $DesktopPath + "\Turtle_exercise"
#$Exercise_folder = $PSScriptRoot + "\out"

javac -d $Exercise_folder *.java

Copy-Item ($PSScriptRoot + "\src\*.*") -Destination $Exercise_folder

attrib +h ($Exercise_folder + "\turtle")
attrib +h ($Exercise_folder + "\Main.class")
attrib +h ($Exercise_folder + "\Main.java")
