// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dialogue.proto

package io.grpc.demo.ask;

public interface ConversationOrBuilder extends
    // @@protoc_insertion_point(interface_extends:demo.Conversation)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * conversation id
   * </pre>
   *
   * <code>string id = 8;</code>
   * @return The id.
   */
  java.lang.String getId();
  /**
   * <pre>
   * conversation id
   * </pre>
   *
   * <code>string id = 8;</code>
   * @return The bytes for id.
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <code>.demo.Message message = 9;</code>
   * @return Whether the message field is set.
   */
  boolean hasMessage();
  /**
   * <code>.demo.Message message = 9;</code>
   * @return The message.
   */
  io.grpc.demo.ask.Message getMessage();
  /**
   * <code>.demo.Message message = 9;</code>
   */
  io.grpc.demo.ask.MessageOrBuilder getMessageOrBuilder();

  /**
   * <pre>
   * 약관등 조회한 내용
   * </pre>
   *
   * <code>repeated .demo.Content content = 10;</code>
   */
  java.util.List<io.grpc.demo.ask.Content> 
      getContentList();
  /**
   * <pre>
   * 약관등 조회한 내용
   * </pre>
   *
   * <code>repeated .demo.Content content = 10;</code>
   */
  io.grpc.demo.ask.Content getContent(int index);
  /**
   * <pre>
   * 약관등 조회한 내용
   * </pre>
   *
   * <code>repeated .demo.Content content = 10;</code>
   */
  int getContentCount();
  /**
   * <pre>
   * 약관등 조회한 내용
   * </pre>
   *
   * <code>repeated .demo.Content content = 10;</code>
   */
  java.util.List<? extends io.grpc.demo.ask.ContentOrBuilder> 
      getContentOrBuilderList();
  /**
   * <pre>
   * 약관등 조회한 내용
   * </pre>
   *
   * <code>repeated .demo.Content content = 10;</code>
   */
  io.grpc.demo.ask.ContentOrBuilder getContentOrBuilder(
      int index);

  /**
   * <code>repeated .demo.Message messageHistory = 11;</code>
   */
  java.util.List<io.grpc.demo.ask.Message> 
      getMessageHistoryList();
  /**
   * <code>repeated .demo.Message messageHistory = 11;</code>
   */
  io.grpc.demo.ask.Message getMessageHistory(int index);
  /**
   * <code>repeated .demo.Message messageHistory = 11;</code>
   */
  int getMessageHistoryCount();
  /**
   * <code>repeated .demo.Message messageHistory = 11;</code>
   */
  java.util.List<? extends io.grpc.demo.ask.MessageOrBuilder> 
      getMessageHistoryOrBuilderList();
  /**
   * <code>repeated .demo.Message messageHistory = 11;</code>
   */
  io.grpc.demo.ask.MessageOrBuilder getMessageHistoryOrBuilder(
      int index);
}
