//
//  CampusMapViewController.h
//  RPIMobile
//
//  Created by Steve on 2/25/13.
//  Copyright (c) 2013 Rensselaer Polytechnic Institute. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <MapKit/MapKit.h>

@interface CampusMapViewController : UIViewController <MKMapViewDelegate, CLLocationManagerDelegate, UISearchBarDelegate, UISearchDisplayDelegate, UITableViewDataSource, UITableViewDelegate> {
    MKMapView *_mapView;
    NSArray *mapPoints;
    NSMutableArray *pins;
    UISearchDisplayController *searchController;
    UITableView *tableView;
}

@end
