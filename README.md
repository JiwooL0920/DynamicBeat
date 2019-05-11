# Overview
**Name:** Jiwoo Lee  
**Last Update:** May 10, 2018 

**Note:** This game may not run properly on Mac platforms as Java Swing is built primarily to run based on Windows platform's look and feel.

The tracks, images, and sound effects are all retrieved from copyright-free sources.

# Descriptions
A study repo to build a rhythm game in Java as a personal project to learn Java programming during summer break; followed online tutorials provided [here](https://blog.naver.com/ndb796/220997028385).

This game uses the **Javazoom** external library provided [here](http://www.javazoom.net/index.shtml) to implement music files. There are a total of 3 tracks in this game, and the player can choose the music and difficulty they wish to play the game with. The objective of this game is to press the respective key at which the note is dropping at the right timing to earn points.

## A Short Demonstration of the Game
![](DynamicBeat.gif)


# How to run this project
## Prerequisites
* Eclipse (or any other Java text editor)
* Java JDK/JRE installed on your local machine (I used JavaSE 1.7 for the JRE System Library for my project; other versions (especially the later ones) may not be compatible to use the Javazoom library)
* Javazoom external library (I have it uploaded in ~/DynamicBeat/lib)

## Instructions
* Clone or download this repo on your Java editor: https://github.com/JiwooL0920/Java-Rhythm-Game.git
* Make sure you have all the prerequisites met, and simply click **run**


# Features
## 1) Screens
* There are a total of 3 screens in this game:  
    **1) Intro:** with title and start/quit button  
    **2) Main Menu:** this is where the players can select their music and difficulty level  
    **3) Game:** this is the game screen where the player's selecte music will play fully and the notes will drop so that the players can begin the game

## 2) Buttons
* There are many buttons in the game that help the user fully make use of the GUI
* First of all, on the rightmost side of the menu bar located at the top of the screen, there is a small **X** button that allows the user to quit the game at any time. This button is present in all 3 of the screens described above
* In the **Intro** screen, there are two buttons:   
    **1) Start:** changes the screen to **Main Menu** where the players can select their music and difficulty  
    **2) Quit:** terminates the game
* In the **Main Menu** screen, there also are two kinds of buttons:
    **1) Track Navigation Buttons:** depicted in left and right arrows, these buttons allow the users to navigate through the track list to select their music to play the game with
    **2) Difficulty Buttons:** allows the user to choose their difficulty level (easy or hard). Upon pressing one of these buttons, the screen will change to the **Game** screen 
* In the **Game** screen, there is the **Back** button which allows the users to go back to the **Main Menu** screen at any point of the game

## 3) Tracks
* There are a total of 3 tracks:   
    **1) Cool - Tobu**  
    **2) Dreams - Joakim Karud**  
    **3) We Are One - Vexento**  

## 4) Difficulties
* Players can select either **easy** or **hard** for each track 
* The **hard** mode has more notes dropping at a faster rate

## 5) Notes and Keyboard Events
* There are a total of 7 notes dropping in a game; each note is controlled by the following keys: **S**, **D**, **F**, **Space Bar**, **J**, **K**, **L**
* The notes dropped reach the judgement line (the red line at the bottom of the game screen) in 1 second
* The user is the press the respective key at the exact time the note falls into the judgement line to earn points
* When pressed, **S**, **D**, **F**,**J**, **K**, and **L** keys make a symbol sound and **Space Bar** makes a snare drum sound


## 6) Judgement of the Note
* There are a total of 6 categories of note judgements with corresponding points granted:  
    **1) Early:** 5 pts  
    **2) Good:** 20 pts  
    **3) Great:** 50 pts  
    **4) Perfect:** 100 pts   
    **5) Late:** 5 pts  
    **6) Miss:** 0 pts  

## 7) Score
* The game keeps track of the overall scores the player achieved throughout the game
* This is placed at the very bottom of the game screen 

## 8) Combo
* This game keeps track of the number of combos the player acieved throughout the game
* Combos are granted if the note judgment is one of the followings: **good**, **great**, **perfect**
* If the note judgment is **early**, **late**, or **missed**, the combo is resetted to 0
* This is placed at the very bottom of the game screen next to score

# What I learned 
