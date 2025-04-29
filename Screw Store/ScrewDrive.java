package fop.w9store;

public enum ScrewDrive {//enum ramdenime konkretul obieqtebs ro qmni shig
    SlotDrive {
        @Override
        public String toString() {
            return "schlitz";
        }
    },
    Cross {
        @Override
        public String toString() {
            return "kreuzschlitz";
        }
    },
    Hex {
        @Override
        public String toString() {
            return "sechskant";
        }
    },
    Torx {
        @Override
        public String toString() {
            return "torx";
        }
    };

    @Override
    public abstract String toString();
}