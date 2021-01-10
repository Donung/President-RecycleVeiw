package com.jirawat.presidentlistrecycleview;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApplication extends Application {

    private static List<President> presidentList = new ArrayList<President>();
    private static int nextId = 10;

    public MyApplication() {
        fillPresidentList();
    }

    private void fillPresidentList() {
        President p0 = new President(0, "George Washington", 1788, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg/160px-Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg");
        President p1 = new President(1, "John Adams",1796,"https://upload.wikimedia.org/wikipedia/commons/thumb/7/70/John_Adams%2C_Gilbert_Stuart%2C_c1800_1815.jpg/160px-John_Adams%2C_Gilbert_Stuart%2C_c1800_1815.jpg");
        President p2 = new President(2, "Abraham Lincoln",1860,"https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/Abraham_Lincoln_O-77_matte_collodion_print.jpg/160px-Abraham_Lincoln_O-77_matte_collodion_print.jpg");
        President p3 = new President(3, "Ulysses S. Grant",1868,"https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/Ulysses_S_Grant_by_Brady_c1870-restored.jpg/160px-Ulysses_S_Grant_by_Brady_c1870-restored.jpg");
        President p4 = new President(4, "Rutherford B. Hayes",1876,"https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/President_Rutherford_Hayes_1870_-_1880_Restored.jpg/160px-President_Rutherford_Hayes_1870_-_1880_Restored.jpg");
        President p5 = new President(5, "Chester A. Arthur",1880,"https://upload.wikimedia.org/wikipedia/commons/thumb/7/79/Chester_Alan_Arthur.jpg/160px-Chester_Alan_Arthur.jpg");
        President p6 = new President(6, "Theodore Roosevelt",1904,"https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/President_Roosevelt_-_Pach_Bros.jpg/160px-President_Roosevelt_-_Pach_Bros.jpg");
        President p7 = new President(7, "Richard Nixon",1972,"https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Richard_Nixon_presidential_portrait_%281%29.jpg/160px-Richard_Nixon_presidential_portrait_%281%29.jpg");
        President p8 = new President(8, "Barack Obama",2008,"https://upload.wikimedia.org/wikipedia/commons/thumb/e/e9/Official_portrait_of_Barack_Obama.jpg/160px-Official_portrait_of_Barack_Obama.jpg");
        President p9 = new President(9, "Donald Trump",2016,"https://upload.wikimedia.org/wikipedia/commons/thumb/a/a2/Donald_Trump_official_portrait_%28cropped_2%29.jpg/160px-Donald_Trump_official_portrait_%28cropped_2%29.jpg");

        presidentList.addAll(Arrays.asList( new President[] { p0, p1, p2, p3, p4, p5, p6, p7, p8, p9}));
    }

    public static List<President> getPresidentList() {
        return presidentList;
    }

    public static void setPresidentList(List<President> presidentList) {
        MyApplication.presidentList = presidentList;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        MyApplication.nextId = nextId;
    }
}
