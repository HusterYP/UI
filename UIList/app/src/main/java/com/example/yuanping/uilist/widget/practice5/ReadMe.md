`UI`练习第五期
参考博客: https://hencoder.com/ui-1-5/

关于**绘制顺序**: 

这里贴一下源博客中总结的比较好的两张图:

<img src="https://github.com/HusterYP/UI/blob/master/Pic/View绘制顺序.png/>

<img src="https://github.com/HusterYP/UI/blob/master/Pic/View绘制顺序表格.png/>

绘制顺序注意事项:
1. 在`ViewGroup`的子类中重写除`dispatchDraw()`以外的绘制方法时, 可能需要调用`setWillNotDraw(false);`

2. 在重写的方法有多个选择时, 优先选择`onDraw()`