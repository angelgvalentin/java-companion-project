'use strict';

angular.module('MGL_Task1_app').controller('GameController',
		[ 'GameService', function(GameService) {
			var self = this;
			self.game = {
				id : '',
				name : '',
				genre : ''
			};
			self.games = [];

			self.fetchAllGames = function(){
				GameService.fetchAllGames().then(function(data) {
					self.games = data;
				});
			}

			self.addGame = function(){
				return GameService.createGame(self.game).then( function() {
				self.fetchAllGames();
				});
			}
			
			self.deleteGame = function(gameToDelete){
				return GameService.deleteGame(gameToDelete.id).then( function() {
				 self.fetchAllGames(); 
				});	
			}
			
			
			self.fetchAllGames();
		} ]);
