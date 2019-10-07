package com.epam.jvmgc.task1;

import java.util.ArrayList;
import java.util.List;

public class SubtaskFive {

    public static void main(String[] args) {
        Chain chain = new Chain();
        chain.setHandlers(8000);
        chain.process();
    }

    private static class Chain {
        private List<Handler> handlers = new ArrayList<>();
        private int n = 0;

        private void setHandlers(int count) {
            int i = 0;
            while (i < count) {
                handlers.add(new Handler());
                i++;
            }
        }

        public void process() {
            if (n < handlers.size()) {
                Handler handler = handlers.get(n++);
                handler.handle(this);
            }
        }
    }

    private static class Handler {
        void handle(Chain chain) {
            chain.process();
        }
    }

}
