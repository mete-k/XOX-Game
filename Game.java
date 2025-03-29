public class Game {
    private Space[][] board = new Space[3][3];
    private int turn = 0;
    

    enum Mark {
        EMPTY, X, O
    }

    private class Space {
        private Mark mark = Mark.EMPTY;

        public Mark getMark() {
            return mark;
        }

        public void setMark(Mark mark) {
            this.mark = mark;
        }
    }
}