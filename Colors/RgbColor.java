package fop.w7color;

public class RgbColor {
    private final int bitDepth;
    private final int red;
    private final int green;
    private final int blue;

    public RgbColor(int bits, int red, int green, int blue) {
        if (bits < 1 || 31 < bits)
            ExceptionUtil.unsupportedOperation("bits invalid " + bits);
        this.bitDepth = bits;
        if (isOutOfRange(bits, red))
            ExceptionUtil.unsupportedOperation("red invalid " + red);
        this.red = red;
        if (isOutOfRange(bits, green))
            ExceptionUtil.unsupportedOperation("green invalid " + green);
        this.green = green;
        if (isOutOfRange(bits, blue))
            ExceptionUtil.unsupportedOperation("blue invalid " + blue);
        this.blue = blue;
    }

    public int getBitDepth() {
        return bitDepth;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public RgbColor8Bit toRgbColor8Bit() {
        return toRgbColor8BitIntern();
    }

    /**
     * could also be directly written in toRgbColor8Bit() and then used in
     * RgbaColor by means of super.toRgbColor8Bit() - would be slightly nicer
     */
    protected RgbColor8Bit toRgbColor8BitIntern() {
        if (bitDepth == 8)
            return new RgbColor8Bit(red, green, blue);
        int red8Bit = convertValueTo8Bit(red);
        int green8Bit = convertValueTo8Bit(green);
        int blue8Bit = convertValueTo8Bit(blue);
        return new RgbColor8Bit(red8Bit, green8Bit, blue8Bit);
    }

    private int convertValueTo8Bit(int val) {
        if (bitDepth > 8) {
            int newVal = val / IntMath.powerOfTwo(bitDepth - 9);
            return Math.min(newVal / 2 + newVal % 2, IntMath.powerOfTwo(8) - 1);
        }
        if (bitDepth < 8) {
            int newVal = val;
            int left = 8 - bitDepth;
            while (left != 0) {
                int shift = Math.min(bitDepth, left);
                newVal = newVal * IntMath.powerOfTwo(shift) + val / IntMath.powerOfTwo(bitDepth - shift);
                left -= shift;
            }
            return newVal;
        }
        return val;
    }

    static boolean isOutOfRange(int bits, int value) {
        if (value < 0)
            return true;
        return value > IntMath.powerOfTwo(bits) - 1;
    }
}