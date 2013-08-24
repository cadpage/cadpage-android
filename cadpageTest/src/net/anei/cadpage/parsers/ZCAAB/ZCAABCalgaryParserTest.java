package net.anei.cadpage.parsers.ZCAAB;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Calgary, AB
Contact: Active911
Agency name: Redwood Meadows Emergency Services
Location: Redwood Meadows, Alberta, Canada
Sender: CAD SMTP1 <Fire-EMSCADTeam@calgary.ca>

(CAD SMS Event) Add: 6 MANYHORSES GA REDM Map:  Det: 23C04I Evt: F2013019467\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 6 MANYHORSES GA REDM Map:  Det: 23 Evt: F2013019467\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: KANA: @MCLEAN CREEK Map:  Det: GRA Evt: F2013019410\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 1 REDWOOD MEADOWS DR REDM: @FH120 Map:  Det: 17 Evt: F2013019312\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: KANA: @MCLEAN CREEK CAMPGROUND Map:  Det: 30B01 Evt: F2013019198\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: KANA: @MCLEAN CREEK CAMPGROUND Map:  Det: 30 Evt: F2013019198\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 45 MEADOW VIEW RD ROCK Map: 23153 Det: FLOC Evt: F2013018849\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 52025 TWP RD 232 ROCK Map: 23152 Det: 23 Evt: F2013018611\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: HWY 22/REDWOOD MEADOWS DR TSUU Map:  Det: 29B04 Evt: F2013018512\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: BRAG: @BRAGG CREEK:GO TO LOKO'S LOUNGE Map: # BRAGG CREEK Det: 31 Evt: F2013018497\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 240020 HWY 22 ROCK: alias 240020 RGE RD 42 ROCK Map: 24042 Det: 30 Evt: F2013018212\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 242008 RGE RD 34 ROCK Map: 24233 Det: 28C01G Evt: F2013018169\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: ROCK: @BRAGG CREEK PROVINCIAL PARK Map: 23150 Det: INV Evt: F2013017238\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: RGE RD 52/TWP RD 232 ROCK Map: 23152 Det: INVC Evt: F2013016974\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: KANA: @CAMP HORIZON Map:  Det: GRA Evt: F2013016555\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: HWY 1/HWY 68 ROCK Map: 25255 Det: 29 Evt: F2013016093\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: HWY 8/HWY 22 ROCK Map: 24142 Det: 01 Evt: F2013014924\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: ARTISTS VIEW DR/OLD BANFF COACH RD ROCK Map: 24425 Det: 29D02p FireTAC: C7 Evt: F2013014834\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 34 MOUNTAIN LION PL ROCK Map: 23450 Det: 31C01 Evt: F2013014615\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 40 WOLF DR REDM Map:  Det: 25B06 Evt: F2013014570\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: HWY 1/HWY 22 ROCK: WB ON HWY 1 KM BEFORE HWY 22 Map: 24541 Det: 29 Evt: F2013014201\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 31069 HWY 1 ROCK: @EXIT 172 EAST BOUND - HWY 1 Map: 24531 Det: 29B04U Evt: F2013013566\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: HWY 1/HWY 68 ROCK Map: 25255 Det: HAZ70 FireTAC: C7 Evt: F2013013492\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: HWY 1/RGE RD 31 ROCK: alias HWY 1/OLD BANFF COACH RD ROCK Map: 24531 Det: 29B04 Evt: F2013013495\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: HWY 1/HERMITAGE RD ROCK Map: 25052 Det: 29B04U FireTAC: C7 Evt: F2013013482\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 252131 RGE RD 54A ROCK Map: 25355 Det: CAS FireTAC: C7 Evt: F2013013280\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: HWY 8/HWY 22 ROCK:4 KM EAST, NORTH SIDE OF HWY 8 Map: 24142 Det: VEH FireTAC: C12 Evt: F2013013181\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: BRAG: @BRAGG CREEK; PAINTBALL COURSE Map: # BRAGG CREEK Det: 26 Evt: F2013013126\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 41144 CIRCLE 5 ESTATES ROCK Map: 24041 Det: 13 Evt: F2013012939\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 44126 HWY 1 ROCK: EST Map: 24544 Det: 29B01 FireTAC: C10 Evt: F2013012215\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: BRAG: @BRAGG CREEK !! SEE NOTES ADDRESS VERIFICATION STILL IN PROGRESS Map: # BRAGG CREEK Det: 29B01A Evt: F2013011969\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 50180 TWP RD 244 ROCK Map: 24450 Det: GRA FireTAC: C10 Evt: F2013011743\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: REDW: @REDWOOD MEADOWS Map:  Det: 21B01 Evt: F2013011672\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 54 WOLF DR REDM Map:  Det: 26 Evt: F2013011199\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: HWY 22/TWP RD 244 ROCK Map: 24342 Det: 24D04 Evt: F2013010754\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: HWY 8/HWY 22 ROCK Map: 24142 Det: 29D02p Evt: F2013010194\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: HWY 1/RGE RD 31 ROCK: alias HWY 1/OLD BANFF COACH RD ROCK Map: 24531 Det: 29B03 Evt: F2013010012\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 2499 HWY 22 TSUU Map:  Det: 12D02E Evt: F2013009588\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 15 PINE AV BRAG Map: # BRAGG CREEK Det: 06 Evt: F2013008546\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 38 SLEIGH DR REDM Map:  Det: 10 Evt: F2013008525\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 1 REDWOOD MEADOWS DR REDM: @FH120 Map:  Det: INVC Evt: F2013007096\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 33 YOHO TINDA RD BRAG Map: # BRAGG CREEK Det: 09E01 Evt: F2013007023\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 50077 BOYCE RANCH RD ROCK Map: 23050 Det: 17 Evt: F2013007032\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 33 YOHO TINDA RD BRAG Map: # BRAGG CREEK Det: 10 Evt: F2013007023\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 324 WILD ROSE CL ROCK Map: 23152 Det: CO Evt: F2013006818\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 30263 RIVER RIDGE DR ROCK Map: 24130 Det: 29 Evt: F2013006228\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 8 YOHO TINDA RD BRAG Map: # BRAGG CREEK Det: 06 Evt: F2013005939\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 226 MOUNTAIN LION DR ROCK Map: 23450 Det: 26 Evt: F2013005866\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: HWY 8/HWY 22 ROCK Map: 24142 Det: 29B04X FireTAC: C6 Evt: F2013005286\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 32136 HWY 1 ROCK: EST 1 KM EAST OF RGE RD 33 EXIT Map: 24532 Det: 29B04 Evt: F2013005279\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 245033 RGE RD 33 ROCK: @CALAWAY PARK Map: 24533 Det: 29 Evt: F2013005274\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 31006 HWY 1 ROCK: EST Map: 24531 Det: 29B04 Evt: F2013005266\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 245033 RGE RD 33 ROCK: @CALAWAY PARK Map: 24533 Det: 29 Evt: F2013005254\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 27 APRIL RD ROCK Map: 23250 Det: 13A01 Evt: F2013004508\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 1 REDWOOD MEADOWS DR REDM: @H120 Map:  Det: INVC Evt: F2013004255\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: HWY 22/TWP RD 244 ROCK Map: 24342 Det: INVC Evt: F2013003612\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 30200 HWY 1 ROCK: @EXIT 172 WEST BOUND - HWY 1 Map: 24530 Det: 29 Evt: F2013002982\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: OLD BANFF COACH RD/HORIZON VIEW RD ROCK Map: 24430 Det: 29 Evt: F2013002951\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 315 RODEO RIDGE ROCK Map: 25130 Det: 30B01 Evt: F2013002837\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 67 RIVER DR N BRAG Map: # BRAGG CREEK Det: 10C04 Evt: F2013002804\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: REDW: @REDWOOD MEADOWS Map:  Det: HAZ70 Evt: F2013001485\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 86 REDWOOD MEADOWS DR REDM Map:  Det: GASHM FireTAC: C7 Evt: F2013001293\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: KANA: @MCLEAN CREEK; CAMPGROUND Map:  Det: VEH Evt: F2013000954\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 28 ECHLIN DR BRAG Map: # BRAGG CREEK Det: 17 Evt: F2013000507\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: KANA: @ELBOW FALLS Map:  Det: 30 Evt: F2013000124\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: 48 MOOSE DR ROCK Map: 23450 Det: 17 Evt: F2012084978\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: HWY 22 TSUU:BRAGG CREEK PAINTBALL Map:  Det: VEH FireTAC: C8 Evt: F2012084619\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Map:  Det: VEH FireTAC: C8 Evt: F2012084619\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.
(CAD SMS Event) Add: BRAG: @BRAGG CREEK: GO TO PAINT BALL Map: # BRAGG CREEK Det: VEH Evt: F2012084619\n\n\nNOTICE -\nThis communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.

Payout: $100

NOTE:Need to check for a : @ in address field, anything following that  got into data.strPlace

*/

public class ZCAABCalgaryParserTest extends BaseParserTest {
  
  public ZCAABCalgaryParserTest() {
    setParser(new ZCAABCalgaryParser(), "CALGARY", "AB");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "(CAD SMS Event) Add: 6 MANYHORSES GA REDM Map:  Det: 23C04I Evt: F2013019467\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:6 MANYHORSES GA",
        "CITY:Redwood Meadows",
        "CALL:Overdose - Cocaine (or derivative)",
        "CODE:23C04I",
        "ID:F2013019467");

    doTest("T2",
        "(CAD SMS Event) Add: 6 MANYHORSES GA REDM Map:  Det: 23 Evt: F2013019467\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:6 MANYHORSES GA",
        "CITY:Redwood Meadows",
        "CALL:Poisoning - Prealert",
        "CODE:23",
        "ID:F2013019467");

    doTest("T3",
        "(CAD SMS Event) Add: KANA: @MCLEAN CREEK Map:  Det: GRA Evt: F2013019410\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:KANA: @MCLEAN CREEK",
        "CALL:Grass Fire",
        "CODE:GRA",
        "ID:F2013019410");

    doTest("T4",
        "(CAD SMS Event) Add: 1 REDWOOD MEADOWS DR REDM: @FH120 Map:  Det: 17 Evt: F2013019312\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:1 REDWOOD MEADOWS DR REDM: @FH120",
        "CALL:Fall - Prealert",
        "CODE:17",
        "ID:F2013019312");

    doTest("T5",
        "(CAD SMS Event) Add: KANA: @MCLEAN CREEK CAMPGROUND Map:  Det: 30B01 Evt: F2013019198\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:KANA: @MCLEAN CREEK CAMPGROUND",
        "CALL:Trauma - Possibly dangerous body area",
        "CODE:30B01",
        "ID:F2013019198");

    doTest("T6",
        "(CAD SMS Event) Add: KANA: @MCLEAN CREEK CAMPGROUND Map:  Det: 30 Evt: F2013019198\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:KANA: @MCLEAN CREEK CAMPGROUND",
        "CALL:Trauma - Prealert",
        "CODE:30",
        "ID:F2013019198");

    doTest("T7",
        "(CAD SMS Event) Add: 45 MEADOW VIEW RD ROCK Map: 23153 Det: FLOC Evt: F2013018849\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:45 MEADOW VIEW RD",
        "CITY:Rocky View County",
        "MAP:23153",
        "CALL:Flooding Incident - Cold Response",
        "CODE:FLOC",
        "ID:F2013018849");

    doTest("T8",
        "(CAD SMS Event) Add: 52025 TWP RD 232 ROCK Map: 23152 Det: 23 Evt: F2013018611\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:52025 TWP RD 232",
        "CITY:Rocky View County",
        "MAP:23152",
        "CALL:Poisoning - Prealert",
        "CODE:23",
        "ID:F2013018611");

    doTest("T9",
        "(CAD SMS Event) Add: HWY 22/REDWOOD MEADOWS DR TSUU Map:  Det: 29B04 Evt: F2013018512\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:HWY 22 & REDWOOD MEADOWS DR",
        "CITY:Tsuu T'ina First Nation",
        "CALL:MVA - Unknown status",
        "CODE:29B04",
        "ID:F2013018512");

    doTest("T10",
        "(CAD SMS Event) Add: BRAG: @BRAGG CREEK:GO TO LOKO'S LOUNGE Map: # BRAGG CREEK Det: 31 Evt: F2013018497\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:BRAG: @BRAGG CREEK: GO TO LOKO'S LOUNGE",
        "MAP:# BRAGG CREEK",
        "CALL:Unconscious/Fainting - Prealert",
        "CODE:31",
        "ID:F2013018497");

    doTest("T11",
        "(CAD SMS Event) Add: 240020 HWY 22 ROCK: alias 240020 RGE RD 42 ROCK Map: 24042 Det: 30 Evt: F2013018212\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:240020 HWY 22",
        "CITY:Rocky View County",
        "MAP:24042",
        "CALL:Trauma - Prealert",
        "CODE:30",
        "ID:F2013018212");

    doTest("T12",
        "(CAD SMS Event) Add: 242008 RGE RD 34 ROCK Map: 24233 Det: 28C01G Evt: F2013018169\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:242008 RGE RD 34",
        "CITY:Rocky View County",
        "MAP:24233",
        "CALL:Stroke - Not alert",
        "CODE:28C01G",
        "ID:F2013018169");

    doTest("T13",
        "(CAD SMS Event) Add: ROCK: @BRAGG CREEK PROVINCIAL PARK Map: 23150 Det: INV Evt: F2013017238\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:ROCK: @BRAGG CREEK PROVINCIAL PARK",
        "MAP:23150",
        "CALL:Investigation",
        "CODE:INV",
        "ID:F2013017238");

    doTest("T14",
        "(CAD SMS Event) Add: RGE RD 52/TWP RD 232 ROCK Map: 23152 Det: INVC Evt: F2013016974\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:RGE RD 52 & TWP RD 232",
        "CITY:Rocky View County",
        "MAP:23152",
        "CALL:Investigation - Cold Response",
        "CODE:INVC",
        "ID:F2013016974");

    doTest("T15",
        "(CAD SMS Event) Add: KANA: @CAMP HORIZON Map:  Det: GRA Evt: F2013016555\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:KANA: @CAMP HORIZON",
        "CALL:Grass Fire",
        "CODE:GRA",
        "ID:F2013016555");

    doTest("T16",
        "(CAD SMS Event) Add: HWY 1/HWY 68 ROCK Map: 25255 Det: 29 Evt: F2013016093\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:HWY 1 & HWY 68",
        "CITY:Rocky View County",
        "MAP:25255",
        "CALL:MVA - Prealert",
        "CODE:29",
        "ID:F2013016093");

    doTest("T17",
        "(CAD SMS Event) Add: HWY 8/HWY 22 ROCK Map: 24142 Det: 01 Evt: F2013014924\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:HWY 8 & HWY 22",
        "CITY:Rocky View County",
        "MAP:24142",
        "CALL:Abdominal pain - Prealert",
        "CODE:01",
        "ID:F2013014924");

    doTest("T18",
        "(CAD SMS Event) Add: ARTISTS VIEW DR/OLD BANFF COACH RD ROCK Map: 24425 Det: 29D02p FireTAC: C7 Evt: F2013014834\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:ARTISTS VIEW DR & OLD BANFF COACH RD",
        "CITY:Rocky View County",
        "MAP:24425",
        "CALL:MVA - High mechanism: Rollovers",
        "CODE:29D02p",
        "CH:C7",
        "ID:F2013014834");

    doTest("T19",
        "(CAD SMS Event) Add: 34 MOUNTAIN LION PL ROCK Map: 23450 Det: 31C01 Evt: F2013014615\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:34 MOUNTAIN LION PL",
        "CITY:Rocky View County",
        "MAP:23450",
        "CALL:Unconscious - Alert with abnormal breathing",
        "CODE:31C01",
        "ID:F2013014615");

    doTest("T20",
        "(CAD SMS Event) Add: 40 WOLF DR REDM Map:  Det: 25B06 Evt: F2013014570\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:40 WOLF DR",
        "CITY:Redwood Meadows",
        "CALL:Psychiatric - Unknown status (3rd party caller)",
        "CODE:25B06",
        "ID:F2013014570");

    doTest("T21",
        "(CAD SMS Event) Add: HWY 1/HWY 22 ROCK: WB ON HWY 1 KM BEFORE HWY 22 Map: 24541 Det: 29 Evt: F2013014201\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:HWY 1 & HWY 22 ROCK: WB ON HWY 1 KM BEFORE HWY 22",
        "MADDR:HWY 1 & HWY 22 ROCK: ON HWY 1 KM BEFORE HWY 22",
        "MAP:24541",
        "CALL:MVA - Prealert",
        "CODE:29",
        "ID:F2013014201");

    doTest("T22",
        "(CAD SMS Event) Add: 31069 HWY 1 ROCK: @EXIT 172 EAST BOUND - HWY 1 Map: 24531 Det: 29B04U Evt: F2013013566\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:31069 HWY 1 ROCK: @EXIT 172 EAST BOUND - HWY 1",
        "MAP:24531",
        "CALL:MVA - Unknown status",
        "CODE:29B04U",
        "ID:F2013013566");

    doTest("T23",
        "(CAD SMS Event) Add: HWY 1/HWY 68 ROCK Map: 25255 Det: HAZ70 FireTAC: C7 Evt: F2013013492\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:HWY 1 & HWY 68",
        "CITY:Rocky View County",
        "MAP:25255",
        "CALL:Public Hazard on Roadway",
        "CODE:HAZ70",
        "CH:C7",
        "ID:F2013013492");

    doTest("T24",
        "(CAD SMS Event) Add: HWY 1/RGE RD 31 ROCK: alias HWY 1/OLD BANFF COACH RD ROCK Map: 24531 Det: 29B04 Evt: F2013013495\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:HWY 1 & RGE RD 31",
        "CITY:Rocky View County",
        "MAP:24531",
        "CALL:MVA - Unknown status",
        "CODE:29B04",
        "ID:F2013013495");

    doTest("T25",
        "(CAD SMS Event) Add: HWY 1/HERMITAGE RD ROCK Map: 25052 Det: 29B04U FireTAC: C7 Evt: F2013013482\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:HWY 1 & HERMITAGE RD",
        "CITY:Rocky View County",
        "MAP:25052",
        "CALL:MVA - Unknown status",
        "CODE:29B04U",
        "CH:C7",
        "ID:F2013013482");

    doTest("T26",
        "(CAD SMS Event) Add: 252131 RGE RD 54A ROCK Map: 25355 Det: CAS FireTAC: C7 Evt: F2013013280\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:252131 RGE RD 54A",
        "CITY:Rocky View County",
        "MAP:25355",
        "CALL:Catalogued Alarm",
        "CODE:CAS",
        "CH:C7",
        "ID:F2013013280");

    doTest("T27",
        "(CAD SMS Event) Add: HWY 8/HWY 22 ROCK:4 KM EAST, NORTH SIDE OF HWY 8 Map: 24142 Det: VEH FireTAC: C12 Evt: F2013013181\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:HWY 8 & HWY 22 ROCK: 4 KM EAST, NORTH SIDE OF HWY 8",
        "MAP:24142",
        "CALL:Vehicle Fire",
        "CODE:VEH",
        "CH:C12",
        "ID:F2013013181");

    doTest("T28",
        "(CAD SMS Event) Add: BRAG: @BRAGG CREEK; PAINTBALL COURSE Map: # BRAGG CREEK Det: 26 Evt: F2013013126\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:BRAG: @BRAGG CREEK; PAINTBALL COURSE",
        "MAP:# BRAGG CREEK",
        "CALL:Sick - Prealert",
        "CODE:26",
        "ID:F2013013126");

    doTest("T29",
        "(CAD SMS Event) Add: 41144 CIRCLE 5 ESTATES ROCK Map: 24041 Det: 13 Evt: F2013012939\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:41144 CIRCLE 5 ESTATES",
        "CITY:Rocky View County",
        "MAP:24041",
        "CALL:Diabetic Problem - Prealert",
        "CODE:13",
        "ID:F2013012939");

    doTest("T30",
        "(CAD SMS Event) Add: 44126 HWY 1 ROCK: EST Map: 24544 Det: 29B01 FireTAC: C10 Evt: F2013012215\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:44126 HWY 1 ROCK: EST",
        "MAP:24544",
        "CALL:MVA - Injuries",
        "CODE:29B01",
        "CH:C10",
        "ID:F2013012215");

    doTest("T31",
        "(CAD SMS Event) Add: BRAG: @BRAGG CREEK !! SEE NOTES ADDRESS VERIFICATION STILL IN PROGRESS Map: # BRAGG CREEK Det: 29B01A Evt: F2013011969\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:BRAG: @BRAGG CREEK !! SEE NOTES ADDRESS VERIFICATION STILL IN PROGRESS",
        "MAP:# BRAGG CREEK",
        "CALL:MVA - Injuries",
        "CODE:29B01A",
        "ID:F2013011969");

    doTest("T32",
        "(CAD SMS Event) Add: 50180 TWP RD 244 ROCK Map: 24450 Det: GRA FireTAC: C10 Evt: F2013011743\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:50180 TWP RD 244",
        "CITY:Rocky View County",
        "MAP:24450",
        "CALL:Grass Fire",
        "CODE:GRA",
        "CH:C10",
        "ID:F2013011743");

    doTest("T33",
        "(CAD SMS Event) Add: REDW: @REDWOOD MEADOWS Map:  Det: 21B01 Evt: F2013011672\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:REDW: @REDWOOD MEADOWS",
        "CALL:Possibly dangerous hemorrhage",
        "CODE:21B01",
        "ID:F2013011672");

    doTest("T34",
        "(CAD SMS Event) Add: 54 WOLF DR REDM Map:  Det: 26 Evt: F2013011199\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:54 WOLF DR",
        "CITY:Redwood Meadows",
        "CALL:Sick - Prealert",
        "CODE:26",
        "ID:F2013011199");

    doTest("T35",
        "(CAD SMS Event) Add: HWY 22/TWP RD 244 ROCK Map: 24342 Det: 24D04 Evt: F2013010754\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:HWY 22 & TWP RD 244",
        "CITY:Rocky View County",
        "MAP:24342",
        "CALL:3rd trimester hemorrhage",
        "CODE:24D04",
        "ID:F2013010754");

    doTest("T36",
        "(CAD SMS Event) Add: HWY 8/HWY 22 ROCK Map: 24142 Det: 29D02p Evt: F2013010194\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:HWY 8 & HWY 22",
        "CITY:Rocky View County",
        "MAP:24142",
        "CALL:MVA - High mechanism: Rollovers",
        "CODE:29D02p",
        "ID:F2013010194");

    doTest("T37",
        "(CAD SMS Event) Add: HWY 1/RGE RD 31 ROCK: alias HWY 1/OLD BANFF COACH RD ROCK Map: 24531 Det: 29B03 Evt: F2013010012\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:HWY 1 & RGE RD 31",
        "CITY:Rocky View County",
        "MAP:24531",
        "CALL:MVA - Other hazards",
        "CODE:29B03",
        "ID:F2013010012");

    doTest("T38",
        "(CAD SMS Event) Add: 2499 HWY 22 TSUU Map:  Det: 12D02E Evt: F2013009588\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:2499 HWY 22",
        "CITY:Tsuu T'ina First Nation",
        "CALL:Seizure - Continuous or multiple seizures",
        "CODE:12D02E",
        "ID:F2013009588");

    doTest("T39",
        "(CAD SMS Event) Add: 15 PINE AV BRAG Map: # BRAGG CREEK Det: 06 Evt: F2013008546\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:15 PINE AV",
        "MADDR:15 PINE AVE",
        "CITY:Bragg Creek",
        "MAP:# BRAGG CREEK",
        "CALL:Abnormal breathing - Prealert",
        "CODE:06",
        "ID:F2013008546");

    doTest("T40",
        "(CAD SMS Event) Add: 38 SLEIGH DR REDM Map:  Det: 10 Evt: F2013008525\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:38 SLEIGH DR",
        "CITY:Redwood Meadows",
        "CALL:Chest Pain - Prealert",
        "CODE:10",
        "ID:F2013008525");

    doTest("T41",
        "(CAD SMS Event) Add: 1 REDWOOD MEADOWS DR REDM: @FH120 Map:  Det: INVC Evt: F2013007096\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:1 REDWOOD MEADOWS DR REDM: @FH120",
        "CALL:Investigation - Cold Response",
        "CODE:INVC",
        "ID:F2013007096");

    doTest("T42",
        "(CAD SMS Event) Add: 33 YOHO TINDA RD BRAG Map: # BRAGG CREEK Det: 09E01 Evt: F2013007023\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:33 YOHO TINDA RD",
        "CITY:Bragg Creek",
        "MAP:# BRAGG CREEK",
        "CALL:Suspected workable arrest – not breathing at all",
        "CODE:09E01",
        "ID:F2013007023");

    doTest("T43",
        "(CAD SMS Event) Add: 50077 BOYCE RANCH RD ROCK Map: 23050 Det: 17 Evt: F2013007032\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:50077 BOYCE RANCH RD",
        "CITY:Rocky View County",
        "MAP:23050",
        "CALL:Fall - Prealert",
        "CODE:17",
        "ID:F2013007032");

    doTest("T44",
        "(CAD SMS Event) Add: 33 YOHO TINDA RD BRAG Map: # BRAGG CREEK Det: 10 Evt: F2013007023\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:33 YOHO TINDA RD",
        "CITY:Bragg Creek",
        "MAP:# BRAGG CREEK",
        "CALL:Chest Pain - Prealert",
        "CODE:10",
        "ID:F2013007023");

    doTest("T45",
        "(CAD SMS Event) Add: 324 WILD ROSE CL ROCK Map: 23152 Det: CO Evt: F2013006818\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:324 WILD ROSE CL",
        "CITY:Rocky View County",
        "MAP:23152",
        "CALL:Carbon Monoxide Incident - Hot Response",
        "CODE:CO",
        "ID:F2013006818");

    doTest("T46",
        "(CAD SMS Event) Add: 30263 RIVER RIDGE DR ROCK Map: 24130 Det: 29 Evt: F2013006228\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:30263 RIVER RIDGE DR",
        "CITY:Rocky View County",
        "MAP:24130",
        "CALL:MVA - Prealert",
        "CODE:29",
        "ID:F2013006228");

    doTest("T47",
        "(CAD SMS Event) Add: 8 YOHO TINDA RD BRAG Map: # BRAGG CREEK Det: 06 Evt: F2013005939\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:8 YOHO TINDA RD",
        "CITY:Bragg Creek",
        "MAP:# BRAGG CREEK",
        "CALL:Abnormal breathing - Prealert",
        "CODE:06",
        "ID:F2013005939");

    doTest("T48",
        "(CAD SMS Event) Add: 226 MOUNTAIN LION DR ROCK Map: 23450 Det: 26 Evt: F2013005866\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:226 MOUNTAIN LION DR",
        "CITY:Rocky View County",
        "MAP:23450",
        "CALL:Sick - Prealert",
        "CODE:26",
        "ID:F2013005866");

    doTest("T49",
        "(CAD SMS Event) Add: HWY 8/HWY 22 ROCK Map: 24142 Det: 29B04X FireTAC: C6 Evt: F2013005286\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:HWY 8 & HWY 22",
        "CITY:Rocky View County",
        "MAP:24142",
        "CALL:MVA - Unknown status",
        "CODE:29B04X",
        "CH:C6",
        "ID:F2013005286");

    doTest("T50",
        "(CAD SMS Event) Add: 32136 HWY 1 ROCK: EST 1 KM EAST OF RGE RD 33 EXIT Map: 24532 Det: 29B04 Evt: F2013005279\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:32136 HWY 1 ROCK: EST 1 KM EAST OF RGE RD 33 EXIT",
        "MADDR:32136 HWY 1 ROCK: EST 1 KM",
        "MAP:24532",
        "CALL:MVA - Unknown status",
        "CODE:29B04",
        "ID:F2013005279");

    doTest("T51",
        "(CAD SMS Event) Add: 245033 RGE RD 33 ROCK: @CALAWAY PARK Map: 24533 Det: 29 Evt: F2013005274\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:245033 RGE RD 33 ROCK: @CALAWAY PARK",
        "MAP:24533",
        "CALL:MVA - Prealert",
        "CODE:29",
        "ID:F2013005274");

    doTest("T52",
        "(CAD SMS Event) Add: 31006 HWY 1 ROCK: EST Map: 24531 Det: 29B04 Evt: F2013005266\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:31006 HWY 1 ROCK: EST",
        "MAP:24531",
        "CALL:MVA - Unknown status",
        "CODE:29B04",
        "ID:F2013005266");

    doTest("T53",
        "(CAD SMS Event) Add: 245033 RGE RD 33 ROCK: @CALAWAY PARK Map: 24533 Det: 29 Evt: F2013005254\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:245033 RGE RD 33 ROCK: @CALAWAY PARK",
        "MAP:24533",
        "CALL:MVA - Prealert",
        "CODE:29",
        "ID:F2013005254");

    doTest("T54",
        "(CAD SMS Event) Add: 27 APRIL RD ROCK Map: 23250 Det: 13A01 Evt: F2013004508\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:27 APRIL RD",
        "CITY:Rocky View County",
        "MAP:23250",
        "CALL:Diabetic Problem - Alert",
        "CODE:13A01",
        "ID:F2013004508");

    doTest("T55",
        "(CAD SMS Event) Add: 1 REDWOOD MEADOWS DR REDM: @H120 Map:  Det: INVC Evt: F2013004255\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:1 REDWOOD MEADOWS DR REDM: @H120",
        "CALL:Investigation - Cold Response",
        "CODE:INVC",
        "ID:F2013004255");

    doTest("T56",
        "(CAD SMS Event) Add: HWY 22/TWP RD 244 ROCK Map: 24342 Det: INVC Evt: F2013003612\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:HWY 22 & TWP RD 244",
        "CITY:Rocky View County",
        "MAP:24342",
        "CALL:Investigation - Cold Response",
        "CODE:INVC",
        "ID:F2013003612");

    doTest("T57",
        "(CAD SMS Event) Add: 30200 HWY 1 ROCK: @EXIT 172 WEST BOUND - HWY 1 Map: 24530 Det: 29 Evt: F2013002982\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:30200 HWY 1 ROCK: @EXIT 172 WEST BOUND - HWY 1",
        "MAP:24530",
        "CALL:MVA - Prealert",
        "CODE:29",
        "ID:F2013002982");

    doTest("T58",
        "(CAD SMS Event) Add: OLD BANFF COACH RD/HORIZON VIEW RD ROCK Map: 24430 Det: 29 Evt: F2013002951\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:OLD BANFF COACH RD & HORIZON VIEW RD",
        "CITY:Rocky View County",
        "MAP:24430",
        "CALL:MVA - Prealert",
        "CODE:29",
        "ID:F2013002951");

    doTest("T59",
        "(CAD SMS Event) Add: 315 RODEO RIDGE ROCK Map: 25130 Det: 30B01 Evt: F2013002837\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:315 RODEO RIDGE",
        "CITY:Rocky View County",
        "MAP:25130",
        "CALL:Trauma - Possibly dangerous body area",
        "CODE:30B01",
        "ID:F2013002837");

    doTest("T60",
        "(CAD SMS Event) Add: 67 RIVER DR N BRAG Map: # BRAGG CREEK Det: 10C04 Evt: F2013002804\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:67 RIVER DR N",
        "CITY:Bragg Creek",
        "MAP:# BRAGG CREEK",
        "CALL:Chest Pain - Breathing normally ≥35",
        "CODE:10C04",
        "ID:F2013002804");

    doTest("T61",
        "(CAD SMS Event) Add: REDW: @REDWOOD MEADOWS Map:  Det: HAZ70 Evt: F2013001485\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:REDW: @REDWOOD MEADOWS",
        "CALL:Public Hazard on Roadway",
        "CODE:HAZ70",
        "ID:F2013001485");

    doTest("T62",
        "(CAD SMS Event) Add: 86 REDWOOD MEADOWS DR REDM Map:  Det: GASHM FireTAC: C7 Evt: F2013001293\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:86 REDWOOD MEADOWS DR",
        "CITY:Redwood Meadows",
        "CALL:Large Gas Leak or Odor in Area",
        "CODE:GASHM",
        "CH:C7",
        "ID:F2013001293");

    doTest("T63",
        "(CAD SMS Event) Add: KANA: @MCLEAN CREEK; CAMPGROUND Map:  Det: VEH Evt: F2013000954\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:KANA: @MCLEAN CREEK; CAMPGROUND",
        "CALL:Vehicle Fire",
        "CODE:VEH",
        "ID:F2013000954");

    doTest("T64",
        "(CAD SMS Event) Add: 28 ECHLIN DR BRAG Map: # BRAGG CREEK Det: 17 Evt: F2013000507\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:28 ECHLIN DR",
        "CITY:Bragg Creek",
        "MAP:# BRAGG CREEK",
        "CALL:Fall - Prealert",
        "CODE:17",
        "ID:F2013000507");

    doTest("T65",
        "(CAD SMS Event) Add: KANA: @ELBOW FALLS Map:  Det: 30 Evt: F2013000124\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:KANA: @ELBOW FALLS",
        "CALL:Trauma - Prealert",
        "CODE:30",
        "ID:F2013000124");

    doTest("T66",
        "(CAD SMS Event) Add: 48 MOOSE DR ROCK Map: 23450 Det: 17 Evt: F2012084978\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:48 MOOSE DR",
        "CITY:Rocky View County",
        "MAP:23450",
        "CALL:Fall - Prealert",
        "CODE:17",
        "ID:F2012084978");

    doTest("T67",
        "(CAD SMS Event) Add: HWY 22 TSUU:BRAGG CREEK PAINTBALL Map:  Det: VEH FireTAC: C8 Evt: F2012084619\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:HWY 22 TSUU: BRAGG CREEK PAINTBALL",
        "CALL:Vehicle Fire",
        "CODE:VEH",
        "CH:C8",
        "ID:F2012084619");

    doTest("T68",
        "(CAD SMS Event) Map:  Det: VEH FireTAC: C8 Evt: F2012084619\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "CALL:Vehicle Fire",
        "CODE:VEH",
        "CH:C8",
        "ID:F2012084619");

    doTest("T69",
        "(CAD SMS Event) Add: BRAG: @BRAGG CREEK: GO TO PAINT BALL Map: # BRAGG CREEK Det: VEH Evt: F2012084619\n\n\n" +
        "NOTICE -\n" +
        "This communication is intended ONLY for the use of the person or entity named above and may contain information that is confidential or legally privileged. If you are not the intended recipient named above or a person responsible for delivering messages or communications to the intended recipient, YOU ARE HEREBY NOTIFIED that any use, distribution, or copying of this communication or any of the information contained in it is strictly prohibited. If you have received this communication in error, please notify us immediately by telephone and then destroy or delete this communication, or return it to us by mail if requested by us. The City of Calgary thanks you for your attention and co-operation.",

        "ADDR:BRAG: @BRAGG CREEK: GO TO PAINT BALL",
        "MAP:# BRAGG CREEK",
        "CALL:Vehicle Fire",
        "CODE:VEH",
        "ID:F2012084619");
  
  }
  
  public static void main(String[] args) {
    new ZCAABCalgaryParserTest().generateTests("T1");
  }
}