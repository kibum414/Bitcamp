package com.example.Homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class CreateTeam {

    private ArrayList<String> AteamArrayList;
    private ArrayList<String> BteamArrayList;

    private String[] AteamArr;
    private String[] BteamArr;

    private int numOfTeam;
    private int AnumOfPerson;
    private int BnumOfPerson;

    public CreateTeam(String[] arrA, String[] arrB, final int TEAMNUMBER) {
        AteamArrayList = new ArrayList<String>();
        BteamArrayList = new ArrayList<String>();

        AteamArr = arrA;
        BteamArr = arrB;

        AnumOfPerson = arrA.length;
        BnumOfPerson = arrB.length;

        numOfTeam = TEAMNUMBER;
    }

    public void allocTeam() {
        allocArrayList(AteamArrayList, AteamArr, AnumOfPerson);
        allocArrayList(BteamArrayList, BteamArr, BnumOfPerson);
    }
    
    public void allocArrayList(ArrayList<String> al, String[] arr, int numOfPerson) {
        for (int i = 0; i < numOfPerson; i++) {
            al.add(arr[i]);
        }

        Collections.shuffle(al);
    }
    
    public void printArrayList(ArrayList<String> al) {
        String name;

        Iterator e = al.iterator();

        int cnt = 1;
        int randValue = 0;
        int teamValue = numOfTeam;

        int quot = al.size() / numOfTeam;
        int remain = al.size() % numOfTeam;

        boolean checkRemain = (remain > 0) ? true : false;

        while (e.hasNext()) {
            name = (String) e.next();
            System.out.printf("%s ", name);

            if (checkRemain) {
                randValue = (int) (Math.random() * 2);

                if (remain == teamValue) randValue = 1;
                if (randValue == 1) remain--;
                if (remain < 0) randValue = 0;
                    
                checkRemain = false;
            }


            if (cnt == (quot + randValue)) {
                System.out.println();

                checkRemain = true;
                randValue = 0;
                cnt = 0;
                teamValue--;
            }

            cnt++;
        }
    }

    public ArrayList<String> getAteamArrayList() {
        return AteamArrayList;
    }

    public ArrayList<String> getBteamArrayList() {
        return BteamArrayList;
    }
}
