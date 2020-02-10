# Basic setup
Set-Location ($PSScriptRoot + "\src")
$DesktopPath = [Environment]::GetFolderPath("Desktop")
$Exercise_folder = $DesktopPath + "\Turtle_exercise"

# Compilation of java file to the exercise folder
javac -d $Exercise_folder *.java

# Copy of java files
Copy-Item ($PSScriptRoot + "\src\*.*") -Destination $Exercise_folder

# Hiding background files
attrib +h ($Exercise_folder + "\turtle")
attrib +h ($Exercise_folder + "\Main.class")
attrib +h ($Exercise_folder + "\Main.java")
