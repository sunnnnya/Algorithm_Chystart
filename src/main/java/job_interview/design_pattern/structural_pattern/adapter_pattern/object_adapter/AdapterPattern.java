package job_interview.design_pattern.structural_pattern.adapter_pattern.object_adapter;

/**
 * @BelongsPackage: structural_pattern.adapter_pattern.object_adapter
 * @ClassName: Adapterpattern
 * @Author: 丛虹羽
 * @Date: 2024/3/21 14:02
 * @Description: 对象适配器模式
 */

// 目标接口
interface SDCard {
    void writeData(String msg);
    String readSD();
}

// 目标接口的实现类
class SDCardImpl implements SDCard {

    @Override
    public void writeData(String msg) {
        System.out.println("SDCard write msg：" + msg);
    }

    @Override
    public String readSD() {
        return "SDCard read data :: hello world SDCard!";
    }
}

// 适配者类的接口
interface TFCard {
    public void writeData(String msg);
    public String readSD();
}

/**
 * 适配者类的接口的实现类
 */
class TFCardImpl implements TFCard {

    @Override
    public void writeData(String msg) {
        System.out.println("TFCard write msg：" + msg);
    }

    @Override
    public String readSD() {
        return "TFCard read data :: hello world TFCard!";
    }
}

class SDAdapterTF implements SDCard {

    /**
     * 为了兼容性考虑，依赖抽象
     */
    private TFCard tfCard;

    public SDAdapterTF(TFCard tfCard) {
        this.tfCard = tfCard;
    }

    @Override
    public void writeData(String msg) {
        tfCard.writeData(msg);
    }

    @Override
    public String readSD() {
        return tfCard.readSD();
    }
}

class Computer {
    /**
     * 从 SD卡中读取数据
     *
     * @param sdCard
     * @return
     */
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
        // 把 TFCardImpl 作为参数传递进去
        String result = computer.readSD(new SDAdapterTF(new TFCardImpl()));
        System.out.println("result = " + result);
    }
}
