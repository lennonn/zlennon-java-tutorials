Result "com.zlennon.jmh.ApplicationBenchmarks.addSelectUsingLinkedList":
320.985 ��(99.9%) 82.643 ops/s [Average]
(min, avg, max) = (174.420, 320.985, 421.378), stdev = 77.304
CI (99.9%): [238.342, 403.627] (assumes normal distribution)
  ==========================
"320.985 ��(99.9%) 82.643 ops/s [Average]" - ���Ǹ�������ÿ�������ƽ�����ʣ�����99.9�����������䡣 �����ű�ʾƽ��ֵ����Χ��������Ϊ82.643 ops/s��
"(min, avg, max) = (174.420, 320.985, 421.378), stdev = 77.304" - �����ṩ���йز����ٶȷֲ��ĸ���ϸ�ڡ��г�����Сֵ��ƽ��ֵ�����ֵ���Լ����ݵı�׼ƫ�
"CI (99.9%): [238.342, 403.627] (assumes normal distribution)" - �����ṩƽ�������ٶȵ�99.9���������䡣����ʾ�����ǿ���������ȷ����ʵƽ���ٶȵ�ֵ��Χ����̬�ֲ��ļ�����ζ������Ԥ����ѭ����������״��



������ÿ�еĺ��壺
Benchmark                                        Mode  Cnt          Score           Error  Units
ApplicationBenchmarks.addSelectUsingArrayList   thrpt   15        459.229 ��       445.700  ops/s
ApplicationBenchmarks.addSelectUsingLinkedList  thrpt   15        320.985 ��        82.643  ops/s
CoreConcepts.benchmark                          thrpt   25  551526688.177 ��  47045261.899  ops/s
CoreConcepts.benchmarkMode                      thrpt   25  559589738.405 ��  52921024.799  ops/s
CoreConcepts.fork                               thrpt   25  794807179.431 ��  27685268.538  ops/s
CoreConcepts.measurement                        thrpt   25  726120913.415 �� 140318120.472  ops/s
CoreConcepts.warmup                             thrpt   25  806138764.830 ��  30180931.870  ops/s

Benchmark����׼���Ե����ơ�
Mode����׼���Ե�ģʽ����������������thrpt����ƽ��ʱ�䣨avgt����
Cnt����׼�������еĴ�����
Score����׼���Ե����֣���ʾ��׼���Ե����ܺû����������ֵĺ���ȡ����ģʽ�͵�λ��
Error����׼���Ե���Χ����ʾ���ֵĲ�ȷ���ȡ�
Units����׼���Եĵ�λ����ʾ���ֵĺ��塣
����������У��ж����ͬ�Ļ�׼���ԣ�ÿ�����Զ�������25�λ�15�Ρ�
CoreConcepts.benchmarkModeģʽ��������ߣ�Ϊ559589738.405 ops/s��CoreConcepts.measurementģʽ��������ͣ�Ϊ726120913.415 ops/s��
�������Ե�������������֮�䣬���Ҿ��в�ͬ����Χ��


ͨ��������������������ֵ����Ϊ������parameter��
���ǿ����õ���ƣ�point estimator�������������������ͳ������������������������ܸ�����������ľ�ȷֵ�������Ҫ�ڵ���ƻ����ϼӼ��߼���margin of error��������������ơ�
�������䣨confidence interval������ʽ�ǣ������ֵ��point estimator�����߼���margin of error��������ˮƽ��confidence level���ǲ����ظ�����ʱ�������Ķ���������ܲ�׽����������ĸ��ʣ�����Ҫ�ص����95%����ˮƽ��ָ��������������У������������ֵ���������ռ��Ϊ95%������