class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        exist = set()
        for num in nums:
            if num not in exist:
                exist.add(num)
            else:
                return num

        return 0