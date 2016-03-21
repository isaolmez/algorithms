package com.isa.section1.chapter2;

public class CircularRotation {

	public static boolean isCircularRotationSlow(String source, String target) {
		if (source == null || target == null || source.length() != target.length()) {
			return false;
		}

		for (int i = 0; i < target.length(); i++) {
			for (int k = 0; k < target.length(); k++) {
				if (target.charAt((k + i) % target.length()) != source.charAt(k)) {
					break;
				}

				if (k == target.length() - 1) {
					return true;
				}
			}
		}

		return false;
	}

	public static boolean isCircularRotationFast(String source, String target) {
		if (source == null || target == null || source.length() != target.length()) {
			return false;
		}

		return (target + target).indexOf(source) > -1;
	}

	public static void main(String[] args) {
		System.out.println(isCircularRotationFast("isa", "sai"));
		System.out.println(isCircularRotationFast("isa", "ssd"));
		System.out.println(isCircularRotationFast("ACTGACG", "TGACGAC"));
	}
}
