package com.ljm;

import java.util.List;

public class LetterTree {
        private String data;
        private List<LetterTree> children;

        public LetterTree() {
        }

        public LetterTree(String data, List<LetterTree> children) {
            this.data = data;
            this.children = children;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public List<LetterTree> getChildren() {
            return children;
        }

        public void setChildren(List<LetterTree> children) {
            this.children = children;
        }
    }