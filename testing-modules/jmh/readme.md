Result "com.zlennon.jmh.ApplicationBenchmarks.addSelectUsingLinkedList":
320.985 ±(99.9%) 82.643 ops/s [Average]
(min, avg, max) = (174.420, 320.985, 421.378), stdev = 77.304
CI (99.9%): [238.342, 403.627] (assumes normal distribution)
  ==========================
"320.985 ±(99.9%) 82.643 ops/s [Average]" - 这是给定过程每秒操作的平均速率，具有99.9％的置信区间。 ±符号表示平均值的误差范围，本例中为82.643 ops/s。
"(min, avg, max) = (174.420, 320.985, 421.378), stdev = 77.304" - 此行提供了有关操作速度分布的更多细节。列出了最小值、平均值和最大值，以及数据的标准偏差。
"CI (99.9%): [238.342, 403.627] (assumes normal distribution)" - 此行提供平均操作速度的99.9％置信区间。它显示了我们可以在其中确定真实平均速度的值范围。正态分布的假设意味着数据预计遵循钟形曲线形状。



以下是每列的含义：
Benchmark                                        Mode  Cnt          Score           Error  Units
ApplicationBenchmarks.addSelectUsingArrayList   thrpt   15        459.229 ±       445.700  ops/s
ApplicationBenchmarks.addSelectUsingLinkedList  thrpt   15        320.985 ±        82.643  ops/s
CoreConcepts.benchmark                          thrpt   25  551526688.177 ±  47045261.899  ops/s
CoreConcepts.benchmarkMode                      thrpt   25  559589738.405 ±  52921024.799  ops/s
CoreConcepts.fork                               thrpt   25  794807179.431 ±  27685268.538  ops/s
CoreConcepts.measurement                        thrpt   25  726120913.415 ± 140318120.472  ops/s
CoreConcepts.warmup                             thrpt   25  806138764.830 ±  30180931.870  ops/s

Benchmark：基准测试的名称。
Mode：基准测试的模式，可能是吞吐量（thrpt）或平均时间（avgt）。
Cnt：基准测试运行的次数。
Score：基准测试的评分，表示基准测试的性能好坏。具体数字的含义取决于模式和单位。
Error：基准测试的误差范围，表示评分的不确定度。
Units：基准测试的单位，表示评分的含义。
在这个例子中，有多个不同的基准测试，每个测试都运行了25次或15次。
CoreConcepts.benchmarkMode模式的评分最高，为559589738.405 ops/s，CoreConcepts.measurement模式的评分最低，为726120913.415 ops/s。
其他测试的评分在这两个之间，并且具有不同的误差范围。


通常是总体比例或者总体均值，称为参数（parameter）
我们可以用点估计（point estimator）估计总体参数的样本统计量，但不能期望点估计量能给出总体参数的精确值，因此需要在点估计基础上加减边际误差（margin of error）来计算区间估计。
置信区间（confidence interval）的形式是：点估计值（point estimator）±边际误差（margin of error），置信水平（confidence level）是不断重复抽样时，构建的多个区间中能捕捉到总体参数的概率（这里要重点理解95%置信水平是指“构建多个区间中，包含总体参数值的区间个数占比为95%”）。