//Brute Force, O(n^3)

//Dynamic, O(n^2)
class Solution {
    public String longestPalindrome(String s) {
		int length = s.length();
		boolean[][] P = new boolean[length][length];
		int maxLen = 0;
		String maxPal = "";
		for (int len = 1; len <= length; len++){
			for (int start = 0; start < length; start++){
				int end = start + len - 1;
				if (end >= length)
					break;
				P[start][end] = (len == 1 || len == 2 || P[start+1][end-1]) && s.charAt(start) == s.charAt(end);
				if (P[start][end] && len > maxLen){
					maxPal = s.substring(start, end + 1);
				}
			}
		}
		return maxPal;
    }
}


//Expand Around Center, O(n^2)
class Solution{
	public String longestPalindrome(String s){
		if ( s == null || s.length() < 1) return "";
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++){
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i+1);
			int len = Math.max(len1, len2);
			if (len > end - start){
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	private int expandAroundCenter(String s, int left, int right){
		int L = left, R = right;
		while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
			L--;
			R++;
		}
		return R - L - 1;
	}
}
