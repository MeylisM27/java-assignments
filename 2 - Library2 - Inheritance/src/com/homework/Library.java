package com.homework;

public class Library {
    private Publication publications[];
    private Integer indexCounter = 0;

    public Library(int numberOfPublications) {
        this.publications = new Publication[numberOfPublications];
    }

    public void storePublication(Publication p){
        if(indexCounter < publications.length) {
            this.publications[indexCounter++] = p;
        } else {return;}
    }

    public Publication getPublication(int i) {
        if(i >= indexCounter) {return null;}
        return this.publications[i];
    }

    public Integer getIndexCounter() {
        return indexCounter;
    }

    public Publication[] searchByTitle(String title) {
        Publication found[] = new Publication[indexCounter];
        Integer counter = 0;

        for(int i=0; i<indexCounter; i++) {
            if(containsIgnoreCase(publications[i].getTitle(), title)) {
                found[counter++] = publications[i];
            }
        }
        return found;
    }

    private boolean containsIgnoreCase(String string, String subString) {
        return string.toLowerCase().contains(subString.toLowerCase());
    }
}
