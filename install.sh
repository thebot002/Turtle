# Basic Setup
DesktopPath=/home/$USER/Desktop
Exercise_folder=$DesktopPath/Turtle_exercise

# Create folder
rm -f -r $Exercise_folder
mkdir $Exercise_folder

# Copying files to folder
cp -r src/* $Exercise_folder

# Compilation of java file to the exercise folder
cd $Exercise_folder
javac *.java

echo "\n\nDone!"
