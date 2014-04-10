#!/bin/sh
java -cp target/tautology-0.0.1-SNAPSHOT.jar pl.waw.mizinski.li.tautology.main.Main '(((A&B)=>(~A+C))+((A&B)=>(~A+C)))=>(A)'
