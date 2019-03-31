package com.Sort;

import java.util.Random;

//mierzy czas dla 5 różnych algorytmów sortowania

public class Time {
    int[] tab = new int[10000];
    int[] pes = new int[10000];
    int[] opt = new int[10000];
    Random generator = new Random();

    public void fillArray(){
        for(int i =0; i<tab.length ;i++){
            tab[i] = generator.nextInt(500);
            pes[i]=tab.length-i;
            opt[i]=i;
        }
    }

    public double bubbleSort(){
        //real
        long tStart = System.currentTimeMillis();

        for(int i =0;i<tab.length-1;i++ ){
            for(int j =0;j<tab.length-i-1;j++)
            {
                int temp = tab[j];
                tab[j] = tab[j+1];
                tab[j+1] = temp;
            }
        }


        long tEnd = System.currentTimeMillis();
        long tDelta = tEnd - tStart;
        double elapsedSeconds = tDelta / 1000.0;

        //pessimistic
        long tStart1 = System.currentTimeMillis();

        for(int i =0;i<pes.length-1;i++ ){
            for(int j =0;j<pes.length-i-1;j++)
            {
                int temp = pes[j];
                pes[j] = pes[j+1];
                pes[j+1] = temp;
            }
        }


        long tEnd1 = System.currentTimeMillis();
        long tDelta1 = tEnd1 - tStart1;
        double elapsedSeconds1 = tDelta1 / 1000.0;

        //optimistic
        long tStart2 = System.currentTimeMillis();

        for(int i =0;i<opt.length-1;i++ ){
            for(int j =0;j<opt.length-i-1;j++)
            {
                int temp = opt[j];
                opt[j] = opt[j+1];
                opt[j+1] = temp;
            }
        }


        long tEnd2 = System.currentTimeMillis();
        long tDelta2 = tEnd2 - tStart2;
        double elapsedSeconds2 = tDelta2 / 1000.0;


        System.out.println("Time for real Bubble Sort: "+elapsedSeconds);
        System.out.println("Time for pessimistic Bubble Sort"+elapsedSeconds1);
        System.out.println("Time for optimistic Bubble Sort"+elapsedSeconds2+"\n");
        return elapsedSeconds;

    }

    public double selectionSort(){
        //real
        long tStart = System.currentTimeMillis();

        for (int i = 0; i < tab.length-1; i++)
        {

            int min_idx = i;
            for (int j = i+1; j < tab.length; j++)
                if (tab[j] < tab[min_idx])
                    min_idx = j;

            int temp = tab[min_idx];
            tab[min_idx] = tab[i];
            tab[i] = temp;
        }

        long tEnd = System.currentTimeMillis();
        long tDelta = tEnd - tStart;
        double elapsedSeconds = tDelta / 1000.0;

        //pessimistic
        long tStart1 = System.currentTimeMillis();

        for (int i = 0; i < pes.length-1; i++)
        {

            int min_idx = i;
            for (int j = i+1; j < pes.length; j++)
                if (pes[j] < pes[min_idx])
                    min_idx = j;

            int temp = pes[min_idx];
            pes[min_idx] = pes[i];
            pes[i] = temp;
        }

        long tEnd1 = System.currentTimeMillis();
        long tDelta1 = tEnd1 - tStart1;
        double elapsedSeconds1 = tDelta1 / 1000.0;

        //optimistic
        long tStart2 = System.currentTimeMillis();

        for (int i = 0; i < opt.length-1; i++)
        {

            int min_idx = i;
            for (int j = i+1; j < opt.length; j++)
                if (opt[j] < opt[min_idx])
                    min_idx = j;

            int temp = opt[min_idx];
            opt[min_idx] = opt[i];
            opt[i] = temp;
        }

        long tEnd2 = System.currentTimeMillis();
        long tDelta2 = tEnd2 - tStart2;
        double elapsedSeconds2 = tDelta2 / 1000.0;

        System.out.println("Time for real Selection Sort: "+elapsedSeconds);
        System.out.println("Time for pessimistic Selection Sort: "+elapsedSeconds1);
        System.out.println("Time for optimistic Selection Sort: "+elapsedSeconds2+"\n");
        return  elapsedSeconds;


    }

    public double shellSort(){
        //real
        long tStart = System.currentTimeMillis();

        for (int gap = tab.length/2; gap > 0; gap /= 2) {
            for (int i = gap; i < tab.length; i += 1) {
                int temp = tab[i];
                int j;

                for (j = i; j >= gap && tab[j - gap] > temp; j -= gap)
                    tab[j] = tab[j - gap];

                tab[j] = temp;
            }
        }

        long tEnd = System.currentTimeMillis();
        long tDelta = tEnd - tStart;
        double elapsedSeconds = tDelta / 1000.0;

        //pessimistic
        long tStart1 = System.currentTimeMillis();

        for (int gap = pes.length/2; gap > 0; gap /= 2) {
            for (int i = gap; i < pes.length; i += 1) {
                int temp = pes[i];
                int j;

                for (j = i; j >= gap && pes[j - gap] > temp; j -= gap)
                    pes[j] = pes[j - gap];

                pes[j] = temp;
            }
        }

        long tEnd1 = System.currentTimeMillis();
        long tDelta1 = tEnd1 - tStart1;
        double elapsedSeconds1 = tDelta1 / 1000.0;

        //optimistic
        long tStart2 = System.currentTimeMillis();

        for (int gap = opt.length/2; gap > 0; gap /= 2) {
            for (int i = gap; i < opt.length; i += 1) {
                int temp = opt[i];
                int j;

                for (j = i; j >= gap && opt[j - gap] > temp; j -= gap)
                    opt[j] = opt[j - gap];

                opt[j] = temp;
            }
        }

        long tEnd2 = System.currentTimeMillis();
        long tDelta2 = tEnd2 - tStart2;
        double elapsedSeconds2 = tDelta2 / 1000.0;

        System.out.println("Time for real Shell Sort: "+elapsedSeconds);
        System.out.println("Time for pessimistic Shell Sort: "+elapsedSeconds1);
        System.out.println("Time for optimistic Shell Sort: "+elapsedSeconds2+"\n");
        return elapsedSeconds;


    }

    public double insertionSort(){
        //real
        long tStart = System.currentTimeMillis();

        for (int i = 1; i < tab.length; ++i) {
            int key = tab[i];
            int j = i - 1;

            while (j >= 0 && tab[j] > key) {
                tab[j + 1] = tab[j];
                j = j - 1;
            }

            tab[j + 1] = key;
        }

        long tEnd = System.currentTimeMillis();
        long tDelta = tEnd - tStart;
        double elapsedSeconds = tDelta / 1000.0;


        //pessimistic
        long tStart1 = System.currentTimeMillis();

        for (int i = 1; i < pes.length; ++i) {
            int key = pes[i];
            int j = i - 1;

            while (j >= 0 && pes[j] > key) {
                pes[j + 1] = pes[j];
                j = j - 1;
            }

            pes[j + 1] = key;
        }

        long tEnd1 = System.currentTimeMillis();
        long tDelta1 = tEnd1 - tStart1;
        double elapsedSeconds1 = tDelta1 / 1000.0;

        //optimistic
        long tStart2 = System.currentTimeMillis();

        for (int i = 1; i < opt.length; ++i) {
            int key = opt[i];
            int j = i - 1;

            while (j >= 0 && opt[j] > key) {
                opt[j + 1] = opt[j];
                j = j - 1;
            }

            opt[j + 1] = key;
        }

        long tEnd2 = System.currentTimeMillis();
        long tDelta2 = tEnd2 - tStart2;
        double elapsedSeconds2 = tDelta2 / 1000.0;

        System.out.println("Time for real Insertion Sort: "+elapsedSeconds);
        System.out.println("Time for pessimistic Insertion Sort: "+elapsedSeconds1);
        System.out.println("Time for optimistic Insertion Sort: "+elapsedSeconds2+"\n");
        return elapsedSeconds;

    }

    public double gnomeSort(){
        //real
        long tStart = System.currentTimeMillis();

        int index = 0;

        while (index < tab.length) {
            if (index == 0)
                index++;
            if (tab[index] >= tab[index - 1])
                index++;
            else {
                int temp = 0;
                temp = tab[index];
                tab[index] = tab[index - 1];
                tab[index - 1] = temp;
                index--;
            }
        }

        long tEnd = System.currentTimeMillis();
        long tDelta = tEnd - tStart;
        double elapsedSeconds = tDelta / 1000.0;

        //pessimistic
        long tStart1 = System.currentTimeMillis();

        int index1 = 0;

        while (index1 < pes.length) {
            if (index1 == 0)
                index1++;
            if (pes[index1] >= pes[index1 - 1])
                index1++;
            else {
                int temp = 0;
                temp = pes[index1];
                pes[index1] = pes[index1 - 1];
                pes[index1 - 1] = temp;
                index1--;
            }
        }

        long tEnd1 = System.currentTimeMillis();
        long tDelta1 = tEnd1 - tStart1;
        double elapsedSeconds1 = tDelta1 / 1000.0;

        //optimistic
        long tStart2 = System.currentTimeMillis();

        int index2 = 0;

        while (index2 < opt.length) {
            if (index2 == 0)
                index2++;
            if (opt[index2] >= opt[index2 - 1])
                index2++;
            else {
                int temp = 0;
                temp = opt[index2];
                opt[index2] = opt[index2 - 1];
                opt[index2 - 1] = temp;
                index2--;
            }
        }

        long tEnd2 = System.currentTimeMillis();
        long tDelta2 = tEnd2 - tStart2;
        double elapsedSeconds2 = tDelta2 / 1000.0;

        System.out.println("Time for real Gnome Sort: "+elapsedSeconds);
        System.out.println("Time for pessimistic Gnome Sort: "+elapsedSeconds1);
        System.out.println("Time for optimistic Gnome Sort: "+elapsedSeconds2);
        return elapsedSeconds;

    }


}
