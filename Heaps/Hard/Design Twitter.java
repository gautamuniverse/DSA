import java.util.*;

public class Solution {
    class Twitter {

        class Tweet {
            int userId;
            int tweetId;

            public Tweet(int userId, int tweetId) {
                this.userId = userId;
                this.tweetId = tweetId;
            }
        }

        HashMap<Integer, Set<Integer>> followings;
        List<Tweet> tweets;

        public Twitter() {
            followings = new HashMap<>();
            tweets = new ArrayList<>();
        }

        public void postTweet(int userId, int tweetId) {
            this.tweets.add(new Tweet(userId, tweetId));
        }

        public List<Integer> getNewsFeed(int userId) {
            int n = this.tweets.size();
            List<Integer> ans = new ArrayList<>();
            Set<Integer> follows = followings.get(userId);

            for (int i = n - 1; i >= 0; i--) {
                if (ans.size() >= 10)
                    return ans;
                Tweet t = this.tweets.get(i);

                if (t.userId == userId || (follows != null && follows.contains(t.userId))) {
                    ans.add(t.tweetId);
                }
            }
            return ans;
        }

        public void follow(int followerId, int followeeId) {
            Set<Integer> set;
            // If the followerId is present as lkey in the followings hashmap then simply
            // get the key value which is the set of followings for the current follower
            if (this.followings.containsKey(followerId)) {
                set = this.followings.get(followerId);
            } else {
                // create a new followings set for the current followerId and push it into the
                // follwoigns hashmap
                set = new HashSet<>();
                this.followings.put(followerId, set);
            }

            // Put the current followeeId to the set
            // If it is such that the current followerId already has the followeeId in the
            // set, then it will not contain duplicate entries
            set.add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            Set<Integer> set = this.followings.get(followerId);
            if (set != null)
                set.remove(followeeId);
        }
    }

}
