package basic_knowledge.bitmap.easy;

/**
 * @BelongsPackage: basic_knowledge.bitmap.easy
 * @ClassName: BitMap
 * @Author: 丛虹羽
 * @Date: 2024/7/27 下午3:40
 * @Description: 位图的实现
 * 位运算的速度大于算数运算的速度
 */
public class BitMapStruct {
    /**
     * 位图的类型
     */
    public static class BitMap {
        // long 8 bytes -> 64 bits
        private long[] bitMap;

        // maxSize = 10000000 -> 实际上用 maxSize / 64个long类型的数来存储
        // 存储 0 ~ 63需要一个 (63 + 64) / 64 = 1 | 0 ~ 63， 存储 0 ~ 64 需要 (64 + 64) / 64 = 2 | 0 ~ 63、64
        public BitMap(int maxSize) {
            this.bitMap = new long[(maxSize + 64) >> 6];
        }

        /**
         * 添加元素到位图中
         * 170 / 64 = 2 -> arr[2]
         * 170 % 64 = 42
         * ... 1 1 0 1 0 1 0 1 ...
         | ... 0 0 0 0 1 0 0 0 ...
         * ... 1 1 0 1 1 1 0 1 ...
         *
         * @param number
         */
        public void add(int number) {
            // number >> 6 <=> number / 64 表示哪个整数
            // number & 63 <=> number % 64 表示余数
            bitMap[(number >> 6)] |= 1L << (number & 63);
        }

        /**
         * 删除位图 中的元素
         * 170 / 64 = 2 -> arr[2]
         * 170 % 64 = 42
         * ... 1 1 0 1 1 1 0 1 ...
         * ... 0 0 0 0 1 0 0 0 ... -> 1L << (number & 63)
         ~ ... 1 1 1 1 0 1 1 1
         & ... 1 1 0 1 0 1 0 1 ...
         *
         * @param number
         */
        public void delete(int number) {
            bitMap[number >> 6] &= ~(1L << (number & 63));
        }

        /**
         * 判断位图中的值是否存在
         *
         * @param number
         * @return
         */
        public boolean exists(int number) {
            return (bitMap[number >> 6] & (1L << (number & 63))) != 0;
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        BitMap bitMap = new BitMap(100);
        bitMap.add(12);
        System.out.println(bitMap.exists(12)); // true
        bitMap.delete(12);
        System.out.println(bitMap.exists(12)); // false
    }
}
