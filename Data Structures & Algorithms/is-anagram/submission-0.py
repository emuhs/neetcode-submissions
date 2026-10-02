class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        sorted_s = ''.join(sorted(s))
        sorted_t = ''.join(sorted(t))
        if len(s) != len(t):
            return False
        else:
            for i in range(0, len(s)):
                if i == len(s) + 1:
                    break
                if sorted_s[i] == sorted_t[i]:
                    continue
                else:
                    return False
            return True
        