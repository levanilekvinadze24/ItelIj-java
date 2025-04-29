package fop.w10pass;

public class Password {
    private final int nrUpperShould, nrLowerShould, nrSpecialShould, nrNumbersShould, lengthShould;
    private final char[] illegalChars;

    public Password(int nrUpperShould, int nrLowerShould, int nrSpecialShould, int nrNumbersShould, int lengthShould, char[] illegalChars) {
        this.nrUpperShould = nrUpperShould;
        this.nrLowerShould = nrLowerShould;
        this.nrSpecialShould = nrSpecialShould;
        this.nrNumbersShould = nrNumbersShould;
        this.lengthShould = lengthShould;
        this.illegalChars = illegalChars;
    }

    private static boolean matchesIllegalCharacter(char[] illegalChars, char c) {
        for (char illegalChar : illegalChars) {
            if (c == illegalChar) {
                return true;
            }
        }
        return false;
    }

    public void checkFormat(String pwd) throws IllegalCharException, NotEnoughException {
        int lengthIs = pwd.length();
        if (lengthIs < lengthShould) {
            throw new NotLongEnoughException(lengthShould, lengthIs);
        }

        int nrLowerIs = 0;
        int nrUpperIs = 0;
        int nrNumbersIs = 0;
        int nrSpecialIs = 0;

        for (int i = 0; i < pwd.length(); i++) {
            char ch = pwd.charAt(i);

            if (matchesIllegalCharacter(illegalChars, ch)) {
                throw new IllegalCharException(ch);
            } else if (ch >= 'a' && ch <= 'z') {
                nrLowerIs++;
            } else if (ch >= 'A' && ch <= 'Z') {
                nrUpperIs++;
            } else if (ch >= '0' && ch <= '9') {
                nrNumbersIs++;
            } else {
                nrSpecialIs++;
            }
        }

        if (nrLowerIs < nrLowerShould) {
            throw new NotEnoughLowerCaseException(nrLowerShould, nrLowerIs);
        }

        if (nrUpperIs < nrUpperShould) {
            throw new NotEnoughUpperCaseException(nrUpperShould, nrUpperIs);
        }

        if (nrNumbersIs < nrNumbersShould) {
            throw new NotEnoughNumberException(nrNumbersShould, nrNumbersIs);
        }

        if (nrSpecialIs < nrSpecialShould) {
            throw new NotEnoughSpecialException(nrSpecialShould, nrSpecialIs);
        }
    }

    public static void main(String[] args) throws NotEnoughException, IllegalCharException {
    }

}
