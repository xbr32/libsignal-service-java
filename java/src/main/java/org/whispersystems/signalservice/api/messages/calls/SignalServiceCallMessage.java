package org.whispersystems.signalservice.api.messages.calls;

import org.whispersystems.libsignal.util.guava.Optional;

public class SignalServiceCallMessage {

  private final Optional<OfferMessage>     offerMessage;
  private final Optional<AnswerMessage>    answerMessage;
  private final Optional<HangupMessage>    hangupMessage;
  private final Optional<BusyMessage>      busyMessage;
  private final Optional<IceUpdateMessage> iceUpdateMessage;

  private SignalServiceCallMessage(Optional<OfferMessage> offerMessage,
                                   Optional<AnswerMessage> answerMessage,
                                   Optional<IceUpdateMessage> iceUpdateMessage,
                                   Optional<HangupMessage> hangupMessage,
                                   Optional<BusyMessage> busyMessage)
  {
    this.offerMessage     = offerMessage;
    this.answerMessage    = answerMessage;
    this.iceUpdateMessage = iceUpdateMessage;
    this.hangupMessage    = hangupMessage;
    this.busyMessage      = busyMessage;
  }

  public static SignalServiceCallMessage forOffer(OfferMessage offerMessage) {
    return new SignalServiceCallMessage(Optional.of(offerMessage),
                                        Optional.<AnswerMessage>absent(),
                                        Optional.<IceUpdateMessage>absent(),
                                        Optional.<HangupMessage>absent(),
                                        Optional.<BusyMessage>absent());
  }

  public static SignalServiceCallMessage forAnswer(AnswerMessage answerMessage) {
    return new SignalServiceCallMessage(Optional.<OfferMessage>absent(),
                                        Optional.of(answerMessage),
                                        Optional.<IceUpdateMessage>absent(),
                                        Optional.<HangupMessage>absent(),
                                        Optional.<BusyMessage>absent());
  }

  public static SignalServiceCallMessage forIceUpdate(IceUpdateMessage iceUpdateMessage) {
    return new SignalServiceCallMessage(Optional.<OfferMessage>absent(),
                                        Optional.<AnswerMessage>absent(),
                                        Optional.of(iceUpdateMessage),
                                        Optional.<HangupMessage>absent(),
                                        Optional.<BusyMessage>absent());
  }

  public static SignalServiceCallMessage forHangup(HangupMessage hangupMessage) {
    return new SignalServiceCallMessage(Optional.<OfferMessage>absent(),
                                        Optional.<AnswerMessage>absent(),
                                        Optional.<IceUpdateMessage>absent(),
                                        Optional.of(hangupMessage),
                                        Optional.<BusyMessage>absent());
  }

  public static SignalServiceCallMessage forBusy(BusyMessage busyMessage) {
    return new SignalServiceCallMessage(Optional.<OfferMessage>absent(),
                                        Optional.<AnswerMessage>absent(),
                                        Optional.<IceUpdateMessage>absent(),
                                        Optional.<HangupMessage>absent(),
                                        Optional.of(busyMessage));
  }


  public static SignalServiceCallMessage empty() {
    return new SignalServiceCallMessage(Optional.<OfferMessage>absent(),
                                        Optional.<AnswerMessage>absent(),
                                        Optional.<IceUpdateMessage>absent(),
                                        Optional.<HangupMessage>absent(),
                                        Optional.<BusyMessage>absent());
  }

  public Optional<IceUpdateMessage> getIceUpdateMessage() {
    return iceUpdateMessage;
  }

  public Optional<AnswerMessage> getAnswerMessage() {
    return answerMessage;
  }

  public Optional<OfferMessage> getOfferMessage() {
    return offerMessage;
  }

  public Optional<HangupMessage> getHangupMessage() {
    return hangupMessage;
  }

  public Optional<BusyMessage> getBusyMessage() {
    return busyMessage;
  }
}
