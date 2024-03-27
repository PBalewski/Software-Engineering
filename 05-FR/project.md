# Auction system

## Introduction

Specification of functional requirements as part of computerisation of the product sale process based on the auction mechanism.

## Business processes

---
<a id="bc1"></a>
### BC1: Auction sale

**Actors:** [Seller](#ac1), [Buyer](#ac2)

**Description:** Business process describing a sale by the auction mechanism.

**Main scenario:**
1. [Seller](#ac1) offers the product at an auction. ([UC1](#uc1))
2. [Buyer](#ac2) offers a bid for the product that is higher than the currently highest bid. ([BR1](#br1))
3. [Buyer](#ac2) wins the auction ([BR2](#br2))
4. [Buyer](#ac2) transfers the amount due to the Seller.
5. [Seller](#ac1) transfers the product to the Buyer.

**Alternative scenarios:** 

2.A. Buyer's bid has been outbid and [Buyer](#ac2) wants to outbid the current highest bid.
* 2.A.1. Continue at step 2.

3.A. Auction time has elapsed and [Buyer](#ac2) has lost the auction. ([BR2](#br2))
* 3.A.1. End of use case.

---

## Actors

<a id="ac1"></a>
### AC1: Seller

A person offering goods at an auction.

<a id="ac2"></a>
### AC2: Buyer

A person intending to purchase a product at an auction..


## User level use cases

### Actors and their goals 

[Seller](#ac1):
* [UC1](#uc1): Offering a product at an auction
* [UC2](#uc2): Transfering a product to the Buyer

[Buyer](#ac2):
* [BR1](#br1): Offering a bid higher than the currently highest bid
* [BR2](#br2): Winning an auction
* [BR3](#br3): Transfering an amount of money to the Seller

---
<a id="uc1"></a>
### UC1: Offering a product at an auction

**Actors:** [Seller](#ac1)

**Main scenario:**
1. [Seller](#ac1) reports to the system the willingness to offer the product up at an auction.
2. System asks for the product data and initial price.
3. [Seller](#ac1) provides product data and the initial price.
4. System verifies data correctness.
5. System informs that the product has been successfully put up for auction.

**Alternative scenarios:** 

4.A. Incorrect or incomplete product data has been entered.
* 4.A.1. informs about incorrectly entered data.
* 4.A.2. Continue at step 2.

---

<a id="uc2"></a>
### UC2: Transfering a product to the Buyer

**Actors:** [Seller](#ac1), [Buyer](#ac2)

**Main scenario:**
1. System asks [Buyer](#act2), who won the auction, for information about delivery (method of reception, addres, etc).
2. System transmits delivery details to [Seller](#act1).
3. [Seller](act#1) sends the parcel.

**Alternative scenarios:** 

1.A. Incomplete addres has been entered.
* 1.A.1. informs about incorrectly entered data.
* 2.A.2. Continue at step 1.

---
---
<a id="br1"></a>
### BR1: Offering a bid higher than the currently highest bid

**Actors:** [Buyer](#ac2)

**Main scenario:**
1. [Buyer](#ac2) reports to the system the willingness to actively participate in auction.
2. System asks for data about the amount of money.
3. [Buyer](#ac2) provides data about the amount of money.
4. System verifies if offer is higher by at least EUR 1.00 than currently biggest offer.
5. System informs that the offer has been succesfully accpted and is the new current winning offer.

**Alternative scenarios:** 

4.A. Offer that is not bigger than at least EUR 1.00 has been entered.
* 4.A.1. informs that offer is not sufficiently high.
* 4.A.2. Continue at step 2.

---

<a id="br2"></a>
### BR2: Winning an auction
**Actors:** [Buyer](#ac2)

**Main scenario:**
1. [Buyer](#ac2) offers a bid higher than the currently highest bid ([BR1](#br1))
2. Auction ends (time expires), [Buyer](#ac2) wins an auction.

**Alternative scenarios:** 

2.A. Auction ends but the final highest offer wasn't fold by [Buyer](#ac2) - he lose an auction.
* 2.A.1. End of use case.

---

<a id="br3"></a>
### BR3: Transfering an amount of money to [Seller](act#1) 
**Actors:** [Buyer](#ac2), [Seller](act#1)

**Main scenario:**
1. [Buyer](#ac2) offers a bid higher than the currently highest bid ([BR1](#br1))
2. Auction ends (time expires), [Buyer](#ac2) wins an auction.

**Alternative scenarios:** 

2.A. Auction ends but the final highest offer wasn't fold by [Buyer](#ac2) - he lose an auction.
* 2.A.1. End of use case.

---


## Business objects (also known as domain or IT objects)

### BO1: Auction

The auction is a form of concluding a sale and purchase transaction in which the Seller specifies the starting bid of the product, while the Buyers may offer their own purchase offer, each time proposing a bid higher than the currently offered bid. The auction ends after a specified period of time. If at least one purchase offer has been submitted, the product is purchased by the Buyer who offered the highest bid. 

### BO2: Product

A physical or digital item to be auctioned.

## Business rules

<a id="br1"></a>
### BR1: Bidding at auction

Bidding at auction requires submitting an amount higher than current by a minimum of EUR 1.00

<a id="br2"></a>
### BR2: Winning an auction

Auction is won by [Buyer](#ac2) who submitted the highest bid before the end of the auction (time expires).


## CRUDL Matrix


| Use case                                  | Auction | Product | ... |
| ----------------------------------------- | ------- | ------- | --- |
| UC1: Offering a product at an auction     |    C    |    C    | ... |
| ???                                       |   ...   |   ...   | ... |


