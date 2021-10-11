//package toby.reactor.practice;
//
//public class PubsubCnt2 {
//
//    @Override
//    public void onSubscribe(Subscription subscription) {
//        System.out.println("onSubscribe");
//        this.subscription = subscription;
////                subscription.request(2);
//        subscription.request(1);
//    }
//
////            int bufferSize = 2;
//
//    @Override
//    public void onNext(Integer item) {
//        System.out.println("onNext " + item);
//        // 2개 이상 받을 때
////                if (--bufferSize <= 0) {
////                    bufferSize = 2;
////                    this.subscription.request(2);
////                }
//        this.subscription.request(1);
//    }
//
//    @Override
//    public void onError(Throwable throwable) {
//        System.out.println("onError");
//    }
//
//    @Override
//    public void onComplete() {
//        System.out.println("onComplete");
//    }
//}
