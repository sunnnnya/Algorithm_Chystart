package job_interview.design_pattern.structural_pattern.adapter_pattern.class_adapter;

/**
 * @BelongsPackage: structural_pattern.adapter_pattern
 * @ClassName: AdapterPattern
 * @Author: 丛虹羽
 * @Date: 2025/5/9 9:3
 * @Description: 类适配器
 */
// 适配者类的接口
interface TFCard {
    /**
     * 从TF卡中读取数据
     */
    String readData();

    /**
     * 写入数据
     */
    void writeData(String msg);
}

/**
 * 适配者类 —— 欧标插孔
 */
class TFCardImpl implements TFCard {
    /**
     * 从TF卡中读取数据
     */
    @Override
    public String readData() {
        String msg = "TFCard read msg: hello world TFCard!!";
        return msg;
    }

    /**
     * 写入数据
     */
    @Override
    public void writeData(String msg) {
        System.out.println("TFCard write msg: " + msg);
    }
}

/**
 * 目标接口 —— 二孔插头
 */
interface SDCard {
    /**
     * 从SD卡中的内容
     * @return
     */
    public String readSD();

    /**
     * 写数据到SD卡
     */
    public void writeSD(String msg);
}

/**
 * SDCrad 的实现类，表示目标接口，computer可以使用的接口
 */
class SDcardImpl implements SDCard {

    @Override
    public String readSD() {
        String msg = "SDCard read data: hello world SDCard";
        return msg;
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("SDCard write msg：" + msg);
    }
}

/**
 * 核心转换器类，适配器类
 * 继承 SDCard 实现方法体现多态，但是使用 TFCardImpl 中的具体方法实现业务逻辑
 * 总结：
 *      实现体现通用性，SDCard sdcard = new SDCardAdapterTFCard();
 *      继承体现，功能服用体现业务逻辑。
 */
class SDCardAdapterTFCard extends TFCardImpl implements SDCard{

    @Override
    public String readSD() {
        /**
         * 直接复用TFCardImpl中的功能来完成，转换器的功能
         */
        return super.readData();
    }

    @Override
    public void writeSD(String msg) {
        super.writeData(msg);
    }
}

/**
 * Computer 类和 SDCard 之间是依赖关系
 * Computer 只能从 SD卡中读取数据
 */
class Computer {
    // 从 SD卡中读取数据
    public String readSD(SDCard sdCard) {
        if (sdCard == null) {
            throw new NullPointerException("sd card is not null");
        }
        return sdCard.readSD();
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        Computer computer = new Computer();
        System.out.println("读取SD卡中的数据");
        String dataFromSDcard = computer.readSD(new SDcardImpl());
        System.out.println("dataFromSDcard = " + dataFromSDcard);
        // dataFromSDcard = SDCard read data: hello world SDCard

        System.out.println("读取TF卡中的数据");
        String dataFromTFCard = computer.readSD(new SDCardAdapterTFCard());
        System.out.println("dataFromTFCard = " + dataFromTFCard);
        // dataFromTFCard = TFCard read msg: hello world TFCard!!
    }
}
