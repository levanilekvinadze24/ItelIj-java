package fop.w7color;

public class RgbaColor extends RgbColor {

    private final int alpha;

    public RgbaColor(int bits, int red, int green, int blue, int alpha) {
        super(bits, red, green, blue);
        if (isOutOfRange(bits, alpha))
            ExceptionUtil.unsupportedOperation("alpha invalid " + alpha);
        this.alpha = alpha;
    }

    public int getAlpha() {
        return alpha;
    }

    @Override
    public RgbColor8Bit toRgbColor8Bit() {
        if (alpha != IntMath.powerOfTwo(getBitDepth()) - 1)
            ExceptionUtil.unsupportedOperation("transparent color cannot be converted to RGB");
        return toRgbColor8BitIntern();
    }
}