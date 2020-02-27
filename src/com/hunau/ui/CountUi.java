/**
 * 
 */
package com.hunau.ui;

/**
 * @author shadow-cxw
 *
 */
import java.awt.Font;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.hunau.pojo.Count;

public class CountUi {
	static ChartPanel frame1;
	public CountUi(List<Count> vector) {
		CategoryDataset dataset = getDataSet(vector);
		JFreeChart chart = ChartFactory.createBarChart3D("�����¼", // ͼ�����
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
		CategoryAxis domainAxis = plot.getDomainAxis(); // ˮƽ�ײ��б�
		domainAxis.setLabelFont(new Font("����", Font.BOLD, 14)); // ˮƽ�ײ�����
		domainAxis.setTickLabelFont(new Font("����", Font.BOLD, 12)); // ��ֱ����
		ValueAxis rangeAxis = plot.getRangeAxis();// ��ȡ��״
		rangeAxis.setLabelFont(new Font("����", Font.BOLD, 15));
		chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));
		chart.getTitle().setFont(new Font("����", Font.BOLD, 20));// ���ñ�������

		// �������������Ȼ�����е�࣬��ֻΪһ��Ŀ�ģ����������������

		frame1 = new ChartPanel(chart, true); // ����Ҳ������chartFrame,����ֱ������һ��������Frame
	}
	public static CategoryDataset getDataSet(List<Count> vector) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(int i=0;i<vector.size();i++) {
			Count eg=vector.get(i);
		dataset.addValue(eg.getMoney(),eg.getAccount(),eg.getKind());
		}
		return dataset;
	}

	public ChartPanel getChartPanel() {
		return frame1;
	}
}