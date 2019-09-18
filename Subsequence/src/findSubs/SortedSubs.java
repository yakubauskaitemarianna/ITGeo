package findSubs;

public class SortedSubs {
	 
    static class NumSubSequence {
        int beginIdex;
        int endIdex;
        int lengthSeq = 2;
 
        NumSubSequence(int beginIdex) {
            this.beginIdex = beginIdex;
        }
 
        NumSubSequence(int beginIdex, int lengthSeq) {
            this.beginIdex = beginIdex;
            this.lengthSeq = lengthSeq;
        }
 
        void riseLength() {
            lengthSeq++;
            endIdex = beginIdex + lengthSeq - 1;
        }
 
        @Override
        public String toString() {
            return "NumSubSequence{" +
                    "beginIdex=" + beginIdex +
                    ", endIdex=" + endIdex +
                    ", lengthSeq=" + lengthSeq +
                    '}';
        }
    }
 
    public static void main(String[] args) {
        NumSubSequence tmpSeq = null;
        NumSubSequence bigestSeq = new NumSubSequence(0, 0);
        int [] sequence = {1, 2, 3, 4, 2, 3, 4, 5, 6, 7, 8, 1};
        for (int i = 0; i < sequence.length - 1; i++) {
            if (sequence[i] < sequence[i + 1]) {
                if (tmpSeq == null)
                    tmpSeq = new NumSubSequence(i);
                else tmpSeq.riseLength();
                if (bigestSeq.lengthSeq < tmpSeq.lengthSeq) bigestSeq = tmpSeq;
            } else tmpSeq = null;
        }
        System.out.println(bigestSeq);
    }
}
