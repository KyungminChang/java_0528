package db.community.service;

import java.util.List;

import db.community.model.vo.CommentVO;
import db.community.model.vo.CommunityVO;
import db.community.model.vo.PostVO;
import db.community.pagination.Criteria;

public interface PostService {

	boolean insertCommunity(String community);

	boolean updateCommunity(String oldName, String newName);

	boolean deleteCommunity(String name);

	boolean insertPost(PostVO post);

	List<CommunityVO> selectCommunityList();

	List<PostVO> getPostList(Criteria cri);

	PostVO getPost(int poNum);

	int selectPostListTotalCount(Criteria cri);

	boolean deletePost(int po_num);

	boolean updatePost(PostVO post);

	boolean insertComment(CommentVO comment);

	List<CommentVO> getCommentList(int po_num);

	void updatePostView(int poNum);

}
