package com.koumanwei.oo.inter;

/**
 * 2017-04-07 下午5:16
 *
 * @author koumanwei
 * @version 1.0
 */
public class InterDemo3 {
    // 接口是对外暴露规则
    // 接口是功能扩展
    // 接口是降低耦合性
    // 接口可以用来多实现

    // 接口和抽象类的区别？
    // 类是用来继承的，只能单继承，接口是用来实现的，可以多实现
    // 类中可以定义非抽象内容，直接给子类使用，接口中只能定义抽象方法，需要子类全部实现
    // 类的继承关系，是 is a关系
    // 接口的实现关系，是 like a关系

    // 共同点：都是不断向上抽取而来的
    // 抽象类是对类抽象，而接口是对行为的抽象。抽象类是对整个类整体进行抽象，
    // 包括属性、行为，但是接口却是对类局部（行为）进行抽象。
}

// 举例：
// 导盲犬 搜爆犬
// 犬中有一些吃饭睡觉等共性行为是不需要抽象的
// 所以用类来定义
abstract class Quan {
    abstract void jiao();
}

class DaoMangQuan extends Quan {
    @Override
    void jiao() {

    }
}

interface SouBao {
    public abstract void souBao();
}

class SouBaoQuan extends Quan implements SouBao {
    @Override
    void jiao() {

    }

    @Override
    public void souBao() {

    }
}