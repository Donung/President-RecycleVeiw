package com.jirawat.presidentlistrecycleview;

import java.util.Comparator;

public class President {
    private int id;
    private String name;
    private int dataOfElection;
    private String imageURL;

    public President(int id, String name, int dataOfElection, String imageURL) {
        this.id = id;
        this.name = name;
        this.dataOfElection = dataOfElection;
        this.imageURL = imageURL;
    }

    public static Comparator<President> PresidentNameAZComparator = new Comparator<President>() {
        @Override
        public int compare(President p1, President p2) {
            return p1.getName().compareTo(p2.getName());
        }
    };

    public static Comparator<President> PresidentNameZAComparator = new Comparator<President>() {
        @Override
        public int compare(President p1, President p2) {
            return p2.getName().compareTo(p1.getName());
        }
    };

    public static Comparator<President> PresidentDateAscendingComparator = new Comparator<President>() {
        @Override
        public int compare(President p1, President p2) {
            return p1.getDataOfElection() - p2.getDataOfElection();
        }
    };

    public static Comparator<President> PresidentDateDescendingComparator = new Comparator<President>() {
        @Override
        public int compare(President p1, President p2) {
            return p2.getDataOfElection() - p1.getDataOfElection();
        }
    };

    @Override
    public String toString() {
        return "President{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dataOfElection=" + dataOfElection +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDataOfElection() {
        return dataOfElection;
    }

    public void setDataOfElection(int dataOfElection) {
        this.dataOfElection = dataOfElection;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
