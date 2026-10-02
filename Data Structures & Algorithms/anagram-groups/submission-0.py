class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        hmap_in = {}
        output = []
        i = 0

        for s in range(len(strs)):
            sorted_str = "".join(sorted(strs[s]))

            if sorted_str not in hmap_in:
                hmap_in[sorted_str] = i
                output.append([strs[s]])
                i += 1
            else:
                output[hmap_in[sorted_str]].append(strs[s])

        return output