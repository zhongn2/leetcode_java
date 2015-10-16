 /*
	 * check a string s is suit for the pattern p
	 * ? is for one character
	 *  * is for one or more characters
	 * innerIndex pointer is when we meet a *, we use innerIndex to move s pointer
	 * and startindex is used the same way for p pointer
	 */
 
 public static boolean ismatch(String s, String p) {
		 // solution 1 : greedy algorithm
		 int sIndex = 0, pIndex = 0, innerIndex = 0, startIndex = -1;
		 
		 while (sIndex < s.length()) {
			 // char in s innerIndexes char in p
			 if (pIndex < p.length() && (p.charAt(pIndex) == '?' || p.charAt(pIndex) == s.charAt(sIndex))) {
				sIndex++;
				pIndex++;
			// meet a '*'
			}else if (pIndex < p.length() && p.charAt(pIndex) == '*') {
				startIndex = pIndex;
				innerIndex = sIndex;
				pIndex++;
			// it means we find a '*'
			}else if (startIndex != -1) {
				 pIndex = startIndex + 1;
				 innerIndex++;
				 sIndex = innerIndex;
			}else {
				return false;
			}
		 }
		 // when p string is only "*" and we need to move pindex 
		 // test case : * * * ......
		 while (pIndex < p.length() && p.charAt(pIndex) == '*') {
				pIndex++;
			}
		 
		return pIndex == p.length();
 }
 
 //C++ version
 class Solution {
public:
    bool isMatch(const char *s, const char *p) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
         
        const char* star=NULL;
        const char* ss=s; 
        while (*s){
            if ((*p=='?')||(*p==*s)){s++;p++;continue;}
            if (*p=='*'){star=p++; ss=s;continue;}
            if (star){ p = star+1; s=++ss;continue;}
            return false;
        }
        while (*p=='*'){p++;}
        return !*p;
    }
};