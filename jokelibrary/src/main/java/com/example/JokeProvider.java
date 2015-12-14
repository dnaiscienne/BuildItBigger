package com.example;

public class JokeProvider {

    public String getJoke(){
        String joke = new String();
        int random = (int )(Math.random() * 10 + 1);

        switch(random){
            case 1:
                joke = "Why did the chicken cross the road? To get to the other side.";
                break;
            case 2:
                joke = "What did one ocean say to the other ocean? Nothing, they just waved.";
                break;
            case 3:
                joke = "If you can’t convince them, confuse them.";
                break;
            case 4:
                joke = "Why is the man who invests all your money called a broker?";
                break;
            case 6:
                joke = "Time flies like an arrow; fruit flies like a banana.";
                break;
            case 7:
                joke = "Thieves had broken into my house and stolen everything except my soap, shower gel, towels and deodorant. Dirty Bastards.";
                break;
            case 8:
                joke = "I wanna make a joke about sodium, but Na..";
                break;
            case 9:
                joke = "I can't believe I got fired from the calendar factory. All I did was take a day off.";
                break;
            case 10:
                joke = "My first job was working in an orange juice factory, but I got canned: couldn't concentrate.";
                break;
            default:
                joke = "This is a funny joke!";
        }


        return joke;
    }
}
