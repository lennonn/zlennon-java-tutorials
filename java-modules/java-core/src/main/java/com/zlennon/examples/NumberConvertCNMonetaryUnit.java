package com.zlennon.examples;

import java.math.BigDecimal;

public class NumberConvertCNMonetaryUnit {
	// ���ִ�д����
	private static final String[] CN_UPPER_NUMBER = { "��", "Ҽ", "��", "��", "��",
			"��", "½", "��", "��", "��" };
	// �����л��ҵ�λ��д����
	private static final String[] CN_UPPER_MONETRAY_UNIT = { "��", "��", "Ԫ",
			"ʰ", "��", "Ǫ", "��", "ʰ", "��", "Ǫ", "��", "ʰ", "��", "Ǫ", "��", "ʰ",
			"��", "Ǫ" };
	// �����ַ�������
	private static final String CN_FULL = "��";
	private static final String CN_NEGATIVE = "��";
	private static final String CN_ZEOR_FULL = "��Ԫ" + CN_FULL;
	// Ĭ�Ͼ��ȣ�2
	private static final int MONEY_PRECISION = 2;

	public String convertNumber(BigDecimal moneny) {
		StringBuffer sb = new StringBuffer();
		int numMoneny = moneny.signum();
		if (numMoneny == 0) {
			return CN_ZEOR_FULL;
		}

		// ��������
		long number = moneny.movePointRight(MONEY_PRECISION).setScale(0, 4)
				.abs().longValue();
		long scale = number % 100;
		int numUnit = 0;
		int numIndex = 0;
		boolean getZero = false;
		// �ж������λ����һ�������������00 = 0, 01 = 1, 10, 11
		if (!(scale > 0)) {
			numIndex = 2;
			number = number / 100;
			getZero = true;
		}
		if ((scale > 0) && (!(scale % 10 > 0))) {
			numIndex = 1;
			number = number / 10;
			getZero = true;
		}
		int zeroSize = 0;
		while (true) {
			if (number <= 0) {
				break;
			}
			// ÿ�λ�ȡ�����һ����
			numUnit = (int) (number % 10);
			if (numUnit > 0) {
				if ((numIndex == 9) && (zeroSize >= 3)) {
					sb.insert(0, CN_UPPER_MONETRAY_UNIT[6]);
				}
				if ((numIndex == 13) && (zeroSize >= 3)) {
					sb.insert(0, CN_UPPER_MONETRAY_UNIT[10]);
				}
				sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
				sb.insert(0, CN_UPPER_NUMBER[numUnit]);
				getZero = false;
				zeroSize = 0;
			} else {
				++zeroSize;
				if (!(getZero)) {
					sb.insert(0, CN_UPPER_NUMBER[numUnit]);
				}
				if (numIndex == 2) {
					if (number > 0) {
						sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
					}
				} else if (((numIndex - 2) % 4 == 0) && (number % 1000 > 0)) {
					sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
				}
				getZero = true;
			}
			// ��numberÿ�ζ�ȥ�����һ����
			number = number / 10;
			++numIndex;
		}
		// ���numMoneny == -1����˵�����������Ϊ������������ǰ��׷�������ַ�����
		if (numMoneny == -1) {
			sb.insert(0, CN_NEGATIVE);
		}
		// ���������С�������λΪ"00"���������Ҫ�����׷�������ַ�����
		if (!(scale > 0)) {
			sb.append(CN_FULL);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		NumberConvertCNMonetaryUnit numberConvertCNMonetaryUnit = new NumberConvertCNMonetaryUnit();
		System.out.println(numberConvertCNMonetaryUnit
				.convertNumber(new BigDecimal(0.228888)));
	}
}
