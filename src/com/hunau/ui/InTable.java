/**
 * 
 */
package com.hunau.ui;

import java.awt.Color;
import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


/**
 * @author shadow-cxw
 *
 */
public class InTable {
	
	static ChartPanel frame1;
	public InTable(int day,int month,int year) {
		CategoryDataset dataset = getDataSet(day,month,year);
		JFreeChart chart = ChartFactory.createBarChart3D("��¼", // ͼ�����
				"����", // Ŀ¼�����ʾ��ǩ
				"���", // ��ֵ�����ʾ��ǩ
				dataset, // ���ݼ�
				PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ
				true, // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)
				false, // �Ƿ����ɹ���
				false // �Ƿ�����URL����
		);
		// �����￪ʼ
		CategoryPlot plot = chart.getCategoryPlot();// ��ȡͼ���������
		//x��
		CategoryAxis domainAxis = plot.getDomainAxis(); // ˮƽ�ײ��б�
		domainAxis.setLabelFont(new Font("����", Font.BOLD, 14)); // ˮƽ�ײ�����
		domainAxis.setTickLabelFont(new Font("����", Font.BOLD, 12)); // ��ֱ����
		/* domainAxis.setAxisLinePaint(Color.red);//X�������ɫ 
	      domainAxis.setTickMarksVisible(true);//������Ƿ���ʾ 
	      domainAxis.setTickMarkOutsideLength(3);//��������ⳤ�� 
	      domainAxis.setTickMarkInsideLength(3);//��������ڳ��� 
	      domainAxis.setTickMarkPaint(Color.red);//�������ɫ 
	      *//**  Y�����ͬX��������  **//* */
		//y��
		ValueAxis rangeAxis = plot.getRangeAxis();// ��ȡ��״
		rangeAxis.setRange(0, 500000);
		rangeAxis.setLabelFont(new Font("����", Font.BOLD, 15));
		chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));
		chart.getTitle().setFont(new Font("����", Font.BOLD, 20));// ���ñ�������

		// �������������Ȼ�����е�࣬��ֻΪһ��Ŀ�ģ����������������

		frame1 = new ChartPanel(chart, true); // ����Ҳ������chartFrame,����ֱ������һ��������Frame
	}
	public static CategoryDataset getDataSet(int day,int month,int year) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(day,"����","����");
		dataset.addValue(month,"����","����");
		dataset.addValue(year,"����","����");
		return dataset;
	}

	public ChartPanel getChartPanel() {
		return frame1;
	}

}
