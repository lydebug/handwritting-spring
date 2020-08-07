package org.leon.bean;

/**
 * @Author: liyang27
 * @Date: 2020/8/6 12:09
 * @Description:
 */
/**
 * 返回数据对象
 */
public class Data {

    /**
     * 模型数据
     */
    private Object model;

    public Data(Object model) {
        this.model = model;
    }

    public Object getModel() {
        return model;
    }
}
